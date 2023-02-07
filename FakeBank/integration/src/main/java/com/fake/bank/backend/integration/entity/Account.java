package com.fake.bank.backend.integration.entity;

import com.fake.bank.backend.common.type.CurrencyType;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "FB_ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrencyType currency;

    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false)
    private User user;
}