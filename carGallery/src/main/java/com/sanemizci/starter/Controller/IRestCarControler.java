package com.sanemizci.starter.controller;

import com.sanemizci.starter.dto.DtoCar;
import com.sanemizci.starter.dto.DtoCarIU;
import jakarta.persistence.criteria.Root;

public interface IRestCarControler {
    public RootEntity<DtoCar> saveCar(DtoCarIU dtoCarIU);

    public RootEntity<DtoCar> getCarById(Long id);

    public RootEntity<DtoCar> updateCar(Long id, DtoCarIU dtoCarIU);

    public RootEntity<DtoCar> deleteCar(Long id);


}
