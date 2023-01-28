package com.fake.bank.backend.rest.controller;

import com.fake.bank.backend.rest.controller.version.RestApiVersion;
import com.fake.bank.backend.rest.model.account.ExchangeDTO;
import com.fake.bank.backend.rest.service.AccountRestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RestApiVersion.version + "/account")
public class AccountController {

    private final AccountRestService accountService;

    public AccountController(AccountRestService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/exchange/{personalNumber}")
    public ResponseEntity<String> exchange(@PathVariable String personalNumber, @RequestBody ExchangeDTO exchangeDTO) {
        accountService.exchange(personalNumber, exchangeDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("exchanged");
    }
}
