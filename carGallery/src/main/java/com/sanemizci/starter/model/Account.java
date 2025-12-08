package com.sanemizci.starter.model;

import com.sanemizci.starter.enums.CurrencyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="Account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntity {

    @Column(name="account_no")
    private String accountNo;
    @Column(name="iban")
    private String IBAN;
    @Column(name="amount")
    private BigDecimal amount;
    @Column(name="currency_type")
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;

}
