package com.sanemizci.starter.Dto;

import com.sanemizci.starter.Enums.CurrencyType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
@Getter
@Setter
public class DtoAccount extends DtoBase{

    private String accountNo;

    private String IBAN;

    private BigDecimal amount;

    private CurrencyType currencyType;
}
