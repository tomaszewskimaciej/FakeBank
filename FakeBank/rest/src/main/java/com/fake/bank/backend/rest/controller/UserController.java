package com.fake.bank.backend.rest.controller;

import com.fake.bank.backend.rest.controller.version.RestApiVersion;
import com.fake.bank.backend.rest.model.user.UserDTO;
import com.fake.bank.backend.rest.service.UserRestService;
import lombok.AllArgsConstructor;
import lombok.Getter;
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

    @GetMapping("/{personalNumber}")
    public ResponseEntity<UserDTO> user(@PathVariable String personalNumber) {
        UserDTO userDTO = service.getUser(personalNumber);
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }
}
