package com.fake.bank.backend.rest.service;

import com.fake.bank.backend.rest.model.user.UserDTO;
import com.fake.bank.backend.rest.service.adapter.UserServiceAdapter;

public class UserRestService {
    private final UserServiceAdapter userServiceAdapter;

    public UserRestService(UserServiceAdapter userServiceAdapter) {
        this.userServiceAdapter = userServiceAdapter;
    }

    public UserDTO getUser(String personalNumber) {
        return userServiceAdapter.getUserByPersonalNumber(personalNumber);
    }
}
