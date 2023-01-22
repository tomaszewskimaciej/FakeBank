package com.fake.bank.backend.rest.controller;

import com.fake.bank.backend.rest.controller.version.RestApiVersion;
import com.fake.bank.backend.rest.model.user.LoginDTO;
import com.fake.bank.backend.rest.model.user.RegistrationDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.status(HttpStatus.OK).body("login");
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("logout");

    }

    @PostMapping("/registration")
    public ResponseEntity<String> registration(@RequestBody RegistrationDTO registrationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body("registration");
    }

}
