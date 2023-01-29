package com.fake.bank.backend.rest.controller;

import com.fake.bank.backend.rest.controller.version.RestApiVersion;
import com.fake.bank.backend.rest.exception.model.FakeBankError;
import com.fake.bank.backend.rest.model.account.ExchangeDTO;
import com.fake.bank.backend.rest.service.AccountRestService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204", description = "NO_CONTENT",
                    content = {@Content(schema = @Schema())}
            ),
            @ApiResponse(
                    responseCode = "400", description = "BAD_REQUEST",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = FakeBankError.class))}
            ),
            @ApiResponse(
                    responseCode = "500", description = "INTERNAL_SERVER_ERROR",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = FakeBankError.class))}
            )
    })
    @PostMapping("/exchange/{personalNumber}")
        public ResponseEntity<Void> exchange(@Parameter(example = "1234567890", required = true) @PathVariable String personalNumber, @Parameter(required = true) @RequestBody ExchangeDTO exchangeDTO) {
        accountService.exchange(personalNumber, exchangeDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
