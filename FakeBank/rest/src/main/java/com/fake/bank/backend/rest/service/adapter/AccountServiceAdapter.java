package com.fake.bank.backend.rest.service.adapter;

import com.fake.bank.backend.rest.model.account.ExchangeDTO;

public interface AccountServiceAdapter {
    void exchange(String personalNumber, ExchangeDTO exchangeDTO);
}
