package com.fake.bank.backend.rest.controller;

import com.fake.bank.backend.rest.controller.version.RestApiVersion;
import com.fake.bank.backend.rest.exception.model.FakeBankError;
import com.fake.bank.backend.rest.model.user.UserDTO;
import com.fake.bank.backend.rest.service.UserRestService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestApiVersion.version + "/user")
public class UserController {
    private final UserRestService service;

    public UserController(UserRestService service) {
        this.service = service;
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "OK",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserDTO.class))}
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
    @GetMapping("/{personalNumber}")
    public ResponseEntity<UserDTO> user(@Parameter(example = "1234567890", required = true) @PathVariable String personalNumber) {
        UserDTO userDTO = service.getUser(personalNumber);
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }
}
