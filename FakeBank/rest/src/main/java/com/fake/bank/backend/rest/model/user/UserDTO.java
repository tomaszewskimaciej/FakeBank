package com.fake.bank.backend.rest.model.user;

import com.fake.bank.backend.rest.model.account.AccountDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @Schema(description = "First name", example = "Jan")
    private String firstName;
    @Schema(description = "Last name", example = "Nowak")
    private String lastName;
    @Schema(description = "Personal number", example = "97043064379")
    private String personalNumber;
    @Schema(description = "List of accounts")
    private List<AccountDTO> accounts;
}
