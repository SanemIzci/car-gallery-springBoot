package com.sanemizci.starter.service;

import com.sanemizci.starter.dto.DtoGallery;
import com.sanemizci.starter.dto.DtoGalleryIU;

public interface IGalleryService {
    public DtoGallery saveGallery(DtoGalleryIU dtoGalleryIU);
}
