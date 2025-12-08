package com.sanemizci.starter.dto;

import com.sanemizci.starter.enums.CurrencyType;
import com.sanemizci.starter.enums.CarStatusType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoCarIU {
    @NotNull
    private String plateNumber;
    @NotNull
    private String brandName;
    @NotNull
    private String model;
    @NotNull
    private Integer productionYear;
    @NotNull
    private BigDecimal price;
    @NotNull
    private CurrencyType currency;
    @NotNull
    private BigDecimal damageCost;
    @NotNull
    private CarStatusType carStatusType;
}
