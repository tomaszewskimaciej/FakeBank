package com.fake.bank.backend.rest.controller;

import com.fake.bank.backend.rest.model.user.LoginDTO;
import com.fake.bank.backend.rest.model.user.RegistrationDTO;
import com.fake.bank.backend.rest.service.LoginRestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class LoginController {

    private final LoginRestService loginService;

    public LoginController(LoginRestService service) {
        this.loginService = service;
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        loginService.login();
        return ResponseEntity.status(HttpStatus.OK).body("login");
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout() {
        loginService.logout();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("logout");

    }

    @PostMapping("/registration")
    public ResponseEntity<String> registration(@Valid @RequestBody RegistrationDTO registrationDTO) {
        loginService.registration(registrationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("registration");
    }

}
