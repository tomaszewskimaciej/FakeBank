package com.fake.bank.backend.rest.service;

import com.fake.bank.backend.rest.model.account.ExchangeDTO;
import com.fake.bank.backend.rest.service.adapter.AccountServiceAdapter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountRestService {
    private final AccountServiceAdapter accountServiceAdapter;
    private final ExchangeRateRestService exchangeRateService;

    public AccountRestService(AccountServiceAdapter accountServiceAdapter, ExchangeRateRestService exchangeRateService) {
        this.accountServiceAdapter = accountServiceAdapter;
        this.exchangeRateService = exchangeRateService;
    }


    public void exchange(String personalNumber, ExchangeDTO exchangeDTO) {
        BigDecimal exchangeRate = exchangeRateService.getExchangeRate(exchangeDTO.getFromCurrency(), exchangeDTO.getToCurrency());
        accountServiceAdapter.exchange(personalNumber, exchangeDTO, exchangeRate);
    }
}
