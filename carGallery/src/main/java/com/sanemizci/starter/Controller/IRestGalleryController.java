package com.sanemizci.starter.controller;

import com.sanemizci.starter.dto.DtoGallery;
import com.sanemizci.starter.dto.DtoGalleryIU;

public interface IRestGalleryController {
    public RootEntity<DtoGallery> createGallery(DtoGalleryIU dtoGalleryIU);
}
