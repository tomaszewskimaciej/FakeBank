package com.fake.bank.backend.rest.service.adapter;

import com.fake.bank.backend.rest.model.account.ExchangeDTO;

import java.math.BigDecimal;

public interface AccountServiceAdapter {
    void exchange(String personalNumber, ExchangeDTO exchangeDTO, BigDecimal exchangeRate);
}
