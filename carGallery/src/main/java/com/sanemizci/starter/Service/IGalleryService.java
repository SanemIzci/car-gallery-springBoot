package com.sanemizci.starter.service;

import com.sanemizci.starter.dto.DtoGallery;
import com.sanemizci.starter.dto.DtoGalleryIU;

public interface IGalleryService {
    public DtoGallery saveGallery(DtoGalleryIU dtoGalleryIU);
    public DtoGallery getGalleryById(Long id);
    public DtoGallery updateGallery(Long id,DtoGalleryIU dtoGalleryIU);
    public DtoGallery deleteGallery(Long id);
}
