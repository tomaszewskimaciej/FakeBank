package com.fake.bank.backend.rest.controller;

import com.fake.bank.backend.rest.controller.version.RestApiVersion;
import com.fake.bank.backend.rest.model.account.ExchangeDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(RestApiVersion.version + "/account")
public class AccountController {

    @PostMapping("/exchange")
    public ResponseEntity<String> exchange(@RequestBody ExchangeDTO exchangeDTO) {
        //need to rethink
        return null;
    }
}
