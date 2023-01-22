package com.fake.bank.backend.integration.adapter;

import com.fake.bank.backend.rest.model.account.ExchangeDTO;
import com.fake.bank.backend.rest.service.adapter.AccountServiceAdapter;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceAdapterImp implements AccountServiceAdapter {
    @Override
    public void exchange(String personalNumber, ExchangeDTO exchangeDTO) {

    }
}
