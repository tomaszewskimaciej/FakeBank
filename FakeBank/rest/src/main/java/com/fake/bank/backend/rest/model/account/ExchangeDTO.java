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
public class ExchangeDTO {
    @Schema(description = "Amount", example = "11.11")
    private BigDecimal amount;
    @Schema(description = "From account currency", example = "PLN")
    private CurrencyType fromCurrency;
    @Schema(description = "To account currency", example = "USD")
    private CurrencyType toCurrency;
}
