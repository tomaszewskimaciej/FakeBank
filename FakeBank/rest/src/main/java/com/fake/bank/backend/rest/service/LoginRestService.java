package com.fake.bank.backend.rest.service;

import com.fake.bank.backend.rest.model.user.RegistrationDTO;
import com.fake.bank.backend.rest.service.adapter.UserServiceAdapter;
import org.springframework.stereotype.Service;

@Service
public class LoginRestService {

    private final UserServiceAdapter service;

    public LoginRestService(UserServiceAdapter service) {
        this.service = service;
    }

    public void login() {

    }

    public void logout() {

    }

    public void registration(RegistrationDTO registrationDTO) {
        service.saveUser(registrationDTO);
    }
}
