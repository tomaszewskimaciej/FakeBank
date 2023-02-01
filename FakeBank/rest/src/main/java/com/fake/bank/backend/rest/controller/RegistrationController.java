package com.fake.bank.backend.rest.controller;

import com.fake.bank.backend.rest.exception.model.FakeBankError;
import com.fake.bank.backend.rest.model.user.RegistrationDTO;
import com.fake.bank.backend.rest.service.RegistrationRestService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RegistrationController {

    private final RegistrationRestService registrationService;

    public RegistrationController(RegistrationRestService service) {
        this.registrationService = service;
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201", description = "CREATED",
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
    @PostMapping("/registration")
    public ResponseEntity<Void> registration(@Parameter(required = true) @Valid @RequestBody RegistrationDTO registrationDTO) {
        registrationService.registration(registrationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
