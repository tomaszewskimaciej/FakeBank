package com.fake.bank.backend.rest.model.user;

import com.fake.bank.backend.rest.validator.annotation.PersonalIdentityNumberValidation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDTO {
    @Schema(description = "First name", example = "Jakub")
    private String firstName;
    @Schema(description = "Last name", example = "Nowak")
    private String lastName;
    @PersonalIdentityNumberValidation()
    @Schema(description = "Personal number", example = "99231877218")
    private String personalNumber;
    @Schema(description = "Amount", example = "333.33")
    private BigDecimal amount;
}
