package com.fake.bank.backend.integration.mapper;

import com.fake.bank.backend.integration.entity.User;
import com.fake.bank.backend.rest.model.user.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDTO mapUserToUserDTO(User user);
}
