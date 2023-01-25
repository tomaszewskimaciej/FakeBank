package com.fake.bank.backend.rest.provider.exchangerate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Rate {
    private String no;
    private String effectiveDate;
    private BigDecimal bid;
    private BigDecimal ask;
}
