package com.fake.bank.backend.integration.service;

import com.fake.bank.backend.common.CurrencyType;
import com.fake.bank.backend.integration.entity.Account;
import com.fake.bank.backend.integration.entity.User;
import com.fake.bank.backend.integration.repository.AccountRepository;
import com.fake.bank.backend.integration.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountService {

    private AccountRepository accountRepository;
    private UserRepository userRepository;

    public AccountService(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public void exchange(String personalNumber, BigDecimal amount, CurrencyType fromCurrencyAccount, CurrencyType toCurrencyAccount) {
        User user = userRepository.findByPersonalNumber(personalNumber).get(0);
        Account fromAccount = getAccountByCurrency(user.getAccounts(), fromCurrencyAccount).orElseThrow(RuntimeException::new);
        Account toAccount = getAccountByCurrency(user.getAccounts(), toCurrencyAccount).orElse(Account.builder().amount(BigDecimal.valueOf(0)).currency(toCurrencyAccount).user(user).build());

        doExchange(fromAccount, toAccount, amount);
    }

    private Optional<Account> getAccountByCurrency(Set<Account> accounts, CurrencyType currencyType) {
        return accounts.stream().filter(a -> currencyType.equals(a.getCurrency())).findFirst();
    }

    private void doExchange(Account fromAccount, Account toAccount, BigDecimal amount) {
        BigDecimal fromAccountAmount = fromAccount.getAmount().subtract(amount);
        BigDecimal toAccountAmount = toAccount.getAmount().add(amount);
        fromAccount.setAmount(fromAccountAmount);
        toAccount.setAmount(toAccountAmount);
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }


    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(int id) {
        return accountRepository.findById(id);
    }

    public void saveOrUpdate(Account account) {
        accountRepository.save(account);
    }

    public void delete(int id) {
        accountRepository.deleteById(id);
    }
}
