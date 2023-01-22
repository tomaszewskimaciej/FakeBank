package com.fake.bank.backend.rest.service;

import com.fake.bank.backend.rest.model.account.ExchangeDTO;
import com.fake.bank.backend.rest.service.adapter.AccountServiceAdapter;

public class AccountRestService {
    private final AccountServiceAdapter accountServiceAdapter;

    public AccountRestService(AccountServiceAdapter accountServiceAdapter) {
        this.accountServiceAdapter = accountServiceAdapter;
    }

    public void exchange(String personalNumber, ExchangeDTO exchangeDTO) {
        try {
            accountServiceAdapter.exchange(personalNumber, exchangeDTO);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
