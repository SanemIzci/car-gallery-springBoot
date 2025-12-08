package com.sanemizci.starter.controller.impl;

import com.sanemizci.starter.controller.IRestGalleryCarsController;
import com.sanemizci.starter.controller.RootEntity;
import com.sanemizci.starter.dto.DtoGalleryCars;
import com.sanemizci.starter.dto.DtoGalleryCarsIU;
import com.sanemizci.starter.service.IGalleryCarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/gallery-cars")
public class RestGalleryCarsControllerImpl implements IRestGalleryCarsController {

    @Autowired
    private IGalleryCarService galleryCarService;
    @PostMapping("/save")
    @Override
    public RootEntity<DtoGalleryCars> saveGalleryCars(@Valid @RequestBody DtoGalleryCarsIU dtoGalleryCarsIU) {
        return RootEntity.ok(galleryCarService.saveGalleryCars(dtoGalleryCarsIU));
    }
}
