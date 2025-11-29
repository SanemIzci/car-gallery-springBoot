package com.sanemizci.starter.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="gallery_cars",uniqueConstraints = {@UniqueConstraint(columnNames = {"gallery_id","car_id"},name="uq_gallerist_car")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GalleryCars extends BaseEntity{

    @ManyToOne
    private Gallery gallery;

    @OneToOne
    private Car car;
}
