package com.sanemizci.starter.service;

import com.sanemizci.starter.dto.DtoGallery;
import com.sanemizci.starter.dto.DtoGalleryCars;
import com.sanemizci.starter.dto.DtoGalleryCarsIU;

public interface IGalleryCarService {
    public DtoGalleryCars saveGalleryCars(DtoGalleryCarsIU dtoGalleryCarsIU);
}
