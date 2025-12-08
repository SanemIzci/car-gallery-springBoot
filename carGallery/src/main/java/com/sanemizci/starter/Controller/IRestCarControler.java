package com.sanemizci.starter.controller;

import com.sanemizci.starter.dto.DtoCar;
import com.sanemizci.starter.dto.DtoCarIU;

public interface IRestCarControler {
    public RootEntity<DtoCar> saveCar(DtoCarIU dtoCarIU);

}
