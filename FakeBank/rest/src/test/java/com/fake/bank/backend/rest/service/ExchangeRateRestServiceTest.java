package com.fake.bank.backend.rest.service;

import com.fake.bank.backend.common.type.CurrencyType;
import com.fake.bank.backend.rest.provider.exchangerate.config.ExchangeRateConfig;
import com.fake.bank.backend.rest.provider.exchangerate.model.ExchangeRateDTO;
import com.fake.bank.backend.rest.provider.exchangerate.model.Rate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@EnableConfigurationProperties(value = ExchangeRateConfig.class)
@ContextConfiguration(initializers = ConfigDataApplicationContextInitializer.class)
@TestPropertySource(properties = {"spring.config.location=classpath:rest.yaml"})
class ExchangeRateRestServiceTest {
    @Autowired
    private ExchangeRateConfig exchangeRateConfig;

    @Mock
    private RestTemplate restTemplate;

    private ExchangeRateRestService exchangeRateService;

    @BeforeEach
    public void beforeEach() {
        exchangeRateService = new ExchangeRateRestService(exchangeRateConfig, restTemplate);
    }

    @ParameterizedTest
    @MethodSource("provideCasesForExchangeRate")
    void shouldReturnProperExchangeRate(CurrencyType from, CurrencyType to, BigDecimal expectedExchangeRate) {
        //given
        given(restTemplate.getForObject(any(), any())).willReturn(getExchangeRateDTO());
        //when
        BigDecimal actual = exchangeRateService.getExchangeRate(from, to);
        //then
        assertEquals(expectedExchangeRate, actual);
    }

    private static Stream<Arguments> provideCasesForExchangeRate() {
        return Stream.of(
                Arguments.of(CurrencyType.PLN, CurrencyType.USD, getExchangeRatePLNtoUSD()),
                Arguments.of(CurrencyType.USD, CurrencyType.PLN, getExchangeRateUSDtoPLN())
        );
    }

    private static BigDecimal getExchangeRatePLNtoUSD() {
        return BigDecimal.valueOf(1).divide(getExchangeRateDTO().getRates().get(0).getAsk(), 4, RoundingMode.FLOOR);
    }

    private static BigDecimal getExchangeRateUSDtoPLN() {
        return getExchangeRateDTO().getRates().get(0).getBid().setScale(4, RoundingMode.FLOOR);
    }

    public static ExchangeRateDTO getExchangeRateDTO() {
        return ExchangeRateDTO.builder()
                .table("C")
                .currency("dolar ameryka??ski")
                .code("USD")
                .rates(List.of(Rate.builder()
                                .no("230/C/NBP/2022")
                                .effectiveDate("2023-02-02")
                                .bid(BigDecimal.valueOf(4))
                                .ask(BigDecimal.valueOf(5))
                                .build()
                        )
                ).build();
    }
}