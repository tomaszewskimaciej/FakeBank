package com.fake.bank.backend.rest.model.account;

import com.fake.bank.backend.common.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeDTO {
    private BigDecimal amount;
    private CurrencyType fromCurrency;
    private CurrencyType toCurrency;
}
