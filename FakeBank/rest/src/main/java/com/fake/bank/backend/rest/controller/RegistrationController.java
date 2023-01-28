package com.fake.bank.backend.rest.controller;

import com.fake.bank.backend.rest.model.user.RegistrationDTO;
import com.fake.bank.backend.rest.service.RegistrationRestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RegistrationController {

    private final RegistrationRestService loginService;

    public RegistrationController(RegistrationRestService service) {
        this.loginService = service;
    }

    @PostMapping("/registration")
    public ResponseEntity<String> registration(@Valid @RequestBody RegistrationDTO registrationDTO) {
        loginService.registration(registrationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
