package com.fake.bank.backend.rest.model.account;

import com.fake.bank.backend.common.type.CurrencyType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class AccountDTO {
    @Schema(description = "Amount", example = "123.00")
    private BigDecimal amount;
    @Schema(description = "Currency", example = "PLN")
    private CurrencyType currency;
}
