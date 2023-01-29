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
public class ExchangeDTO {
    @Schema(description = "Amount", example = "11.11")
    private BigDecimal amount;
    @Schema(description = "From account currency", example = "PLN")
    private CurrencyType fromCurrency;
    @Schema(description = "To account currency", example = "USD")
    private CurrencyType toCurrency;
}
