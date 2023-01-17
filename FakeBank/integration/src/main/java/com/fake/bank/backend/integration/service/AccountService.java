package com.fake.bank.backend.integration.service;

import com.fake.bank.backend.integration.entity.Account;
import com.fake.bank.backend.integration.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    AccountRepository repository;


    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    public Optional<Account> getAccountById(int id) {
        return repository.findById(id);
    }

    public void saveOrUpdate(Account account) {
        repository.save(account);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
