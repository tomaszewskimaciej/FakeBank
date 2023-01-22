package com.fake.bank.backend.integration.mapper;

import com.fake.bank.backend.integration.entity.Account;
import com.fake.bank.backend.rest.model.account.AccountDTO;
import org.mapstruct.Mapper;

@Mapper
public interface AccountMapper {
    AccountDTO mapAccountToAccountDTO(Account account);
}
