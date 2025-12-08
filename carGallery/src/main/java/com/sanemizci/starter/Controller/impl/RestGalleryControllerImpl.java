package com.sanemizci.starter.controller.impl;

import com.sanemizci.starter.controller.IRestGalleryController;
import com.sanemizci.starter.controller.RootEntity;
import com.sanemizci.starter.dto.DtoGallery;
import com.sanemizci.starter.dto.DtoGalleryIU;
import com.sanemizci.starter.service.IGalleryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import static com.sanemizci.starter.controller.RootEntity.ok;

@RestController
@RequestMapping("/rest/api/gallery")
public class RestGalleryControllerImpl implements IRestGalleryController {
    @Autowired
    private IGalleryService galleryService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoGallery> createGallery(@Valid @RequestBody DtoGalleryIU dtoGalleryIU) {
        return ok(galleryService.saveGallery(dtoGalleryIU));
    }
}
