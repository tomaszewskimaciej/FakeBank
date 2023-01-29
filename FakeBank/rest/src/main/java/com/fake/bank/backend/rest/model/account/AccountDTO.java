package com.fake.bank.backend.rest.model.account;

import com.fake.bank.backend.common.type.CurrencyType;
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
public class AccountDTO {
    @Schema(description = "Amount", example = "123.00")
    private BigDecimal amount;
    @Schema(description = "Currency", example = "PLN")
    private CurrencyType currency;
}
