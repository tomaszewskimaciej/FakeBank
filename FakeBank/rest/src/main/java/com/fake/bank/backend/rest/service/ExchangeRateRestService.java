package com.fake.bank.backend.rest.service;

import com.fake.bank.backend.common.exception.FakeBankException;
import com.fake.bank.backend.common.exception.type.FakeBankErrorType;
import com.fake.bank.backend.common.type.CurrencyType;
import com.fake.bank.backend.rest.provider.exchangerate.config.ExchangeRateConfig;
import com.fake.bank.backend.rest.provider.exchangerate.model.ExchangeRateDTO;
import com.fake.bank.backend.rest.provider.exchangerate.model.Rate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ExchangeRateRestService {
    private final ExchangeRateConfig exchangeRateConfig;
    private final RestTemplate restTemplate = new RestTemplate();

    public ExchangeRateRestService(ExchangeRateConfig exchangeRateConfig) {
        this.exchangeRateConfig = exchangeRateConfig;
    }

    public BigDecimal getExchangeRate(CurrencyType from, CurrencyType to) {
        if (exchangeRateConfig.getMainCurrency().equals(from) && exchangeRateConfig.getMainCurrency().equals(to) == false) {
            return new BigDecimal(1).divide(getExchangeRate(to).getAsk(), 4, RoundingMode.FLOOR);
        }

        if (exchangeRateConfig.getMainCurrency().equals(to) && exchangeRateConfig.getMainCurrency().equals(from) == false) {
            return getExchangeRate(from).getBid().setScale(4, RoundingMode.FLOOR);
        }

        throw new FakeBankException(FakeBankErrorType.FB_499);
    }

    private Rate getExchangeRate(CurrencyType currencyType) {

        try {
            ExchangeRateDTO exchangeRateDTO = restTemplate.getForObject(exchangeRateConfig.buildUrl(currencyType.toString()), ExchangeRateDTO.class);

            if (exchangeRateDTO == null || exchangeRateDTO.getRates() == null) {
                throw new FakeBankException(FakeBankErrorType.FB_598);
            }

            return exchangeRateDTO.getRates().stream().findFirst().orElseThrow(() -> new FakeBankException(FakeBankErrorType.FB_598));
        } catch (RestClientException e) {
            throw new FakeBankException(FakeBankErrorType.FB_597);
        }
    }
}
