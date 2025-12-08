package com.sanemizci.starter.dto;

import com.sanemizci.starter.enums.CarStatusType;
import com.sanemizci.starter.enums.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoCar extends DtoBase {
    private String plateNumber;
    private String brandName;
    private String model;
    private Integer productionYear;
    private BigDecimal price;
    private CurrencyType currency;
    private BigDecimal damageCost;
    private CarStatusType carStatusType;
}
