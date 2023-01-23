package com.fake.bank.backend.rest.service.adapter;

import com.fake.bank.backend.rest.model.user.RegistrationDTO;
import com.fake.bank.backend.rest.model.user.UserDTO;

public interface UserServiceAdapter {
    UserDTO getUserByPersonalNumber(String personalNumber);

    void saveUser(RegistrationDTO registrationDTO);
}
