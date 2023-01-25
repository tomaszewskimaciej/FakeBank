package com.fake.bank.backend.integration.adapter;

import com.fake.bank.backend.integration.service.AccountService;
import com.fake.bank.backend.rest.model.account.ExchangeDTO;
import com.fake.bank.backend.rest.service.adapter.AccountServiceAdapter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceAdapterImp implements AccountServiceAdapter {
    private AccountService accountService;


    @Override
    public void exchange(String personalNumber, ExchangeDTO exchangeDTO, BigDecimal exchangeRate) {
        accountService.exchange(personalNumber, exchangeDTO.getAmount(), exchangeDTO.getFromCurrency(), exchangeDTO.getToCurrency(), exchangeRate);
    }
}
