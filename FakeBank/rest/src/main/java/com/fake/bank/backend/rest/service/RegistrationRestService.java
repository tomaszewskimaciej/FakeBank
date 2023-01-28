package com.fake.bank.backend.rest.service;

import com.fake.bank.backend.rest.model.user.RegistrationDTO;
import com.fake.bank.backend.rest.service.adapter.UserServiceAdapter;
import org.springframework.stereotype.Service;

@Service
public class RegistrationRestService {

    private final UserServiceAdapter service;

    public RegistrationRestService(UserServiceAdapter service) {
        this.service = service;
    }

    public void registration(RegistrationDTO registrationDTO) {
        service.saveUser(registrationDTO);
    }
}
