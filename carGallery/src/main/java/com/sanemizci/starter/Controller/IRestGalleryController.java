package com.sanemizci.starter.controller;

import com.sanemizci.starter.dto.DtoGallery;
import com.sanemizci.starter.dto.DtoGalleryIU;

public interface IRestGalleryController {
    public RootEntity<DtoGallery> createGallery(DtoGalleryIU dtoGalleryIU);
    public RootEntity<DtoGallery> getGalleryById(Long id);
    public RootEntity<DtoGallery> deleteGallery(Long id);
    public RootEntity<DtoGallery> updateGallery(Long id,DtoGalleryIU dtoGalleryIU);
 }
