package com.fake.bank.backend.integration.adapter;

import com.fake.bank.backend.integration.entity.User;
import com.fake.bank.backend.integration.mapper.UserMapper;
import com.fake.bank.backend.integration.service.UserService;
import com.fake.bank.backend.rest.model.user.UserDTO;
import com.fake.bank.backend.rest.service.adapter.UserServiceAdapter;
import org.springframework.stereotype.Service;

@Service
public class UserServiceAdapterImp implements UserServiceAdapter {

    private final UserService service;
    private final UserMapper userMapper;

    public UserServiceAdapterImp(UserService service, UserMapper userMapper) {
        this.service = service;
        this.userMapper = userMapper;
    }


    @Override
    public UserDTO getUserByPersonalNumber(String personalNumber) {
        User user = service.findUserByPersonalNumber(personalNumber);
        return userMapper.mapUserToUserDTO(user);
    }
}
