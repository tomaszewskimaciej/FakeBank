package com.fake.bank.backend.integration.mapper;

import com.fake.bank.backend.common.type.CurrencyType;
import com.fake.bank.backend.integration.entity.Account;
import com.fake.bank.backend.integration.entity.User;
import com.fake.bank.backend.rest.model.user.RegistrationDTO;
import com.fake.bank.backend.rest.model.user.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.math.BigDecimal;
import java.util.Set;

@Mapper
public interface UserMapper {
    String CREATE_ACCOUNT = "CREATE_ACCOUNT";

    UserDTO mapUserToUserDTO(User user);

    @Mapping(source = "registrationDTO.amount", target = "accounts", qualifiedByName = CREATE_ACCOUNT)
    User mapRegistrationDTOtoUser(RegistrationDTO registrationDTO);

    @Named(CREATE_ACCOUNT)
    default Set<Account> createAccount(BigDecimal amount) {
        return Set.of(Account.builder().amount(amount).currency(CurrencyType.PLN).build());
    }
}
