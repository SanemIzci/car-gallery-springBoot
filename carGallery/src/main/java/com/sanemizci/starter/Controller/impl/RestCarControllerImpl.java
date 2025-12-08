package com.sanemizci.starter.controller.impl;

import com.sanemizci.starter.controller.IRestCarControler;
import com.sanemizci.starter.controller.RootEntity;
import com.sanemizci.starter.dto.DtoCar;
import com.sanemizci.starter.dto.DtoCarIU;
import com.sanemizci.starter.service.ICarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/rest/api/car")
public class RestCarControllerImpl extends RootEntity implements IRestCarControler {
    @Autowired
    private ICarService carService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoCar> saveCar(@Valid @RequestBody DtoCarIU dtoCarIU) {
        return ok(carService.saveCar(dtoCarIU));
    }
}
