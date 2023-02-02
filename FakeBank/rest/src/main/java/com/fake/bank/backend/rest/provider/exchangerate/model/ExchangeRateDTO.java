package com.fake.bank.backend.rest.provider.exchangerate.model;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class ExchangeRateDTO {
    private String table;
    private String currency;
    private String code;
    private List<Rate> rates;

}
