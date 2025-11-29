package com.sanemizci.starter.Model;

import com.sanemizci.starter.Enums.CarStatusType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.sanemizci.starter.Enums.CurrencyType;
import java.math.BigDecimal;

@Entity
@Table(name="car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Car extends BaseEntity {

    @Column(name = "plate_number")
    private String plateNumber;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "model")
    private String model;

    @Column(name = "production_year")
    private Integer productionYear;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    private CurrencyType currency;

    @Column(name = "damage_cost")
    private BigDecimal damageCost;

    @Column(name = "car_status_type")
    @Enumerated(EnumType.STRING)
    private CarStatusType carStatusType;
}
