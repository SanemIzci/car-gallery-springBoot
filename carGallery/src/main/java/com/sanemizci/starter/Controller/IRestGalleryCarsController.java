package com.sanemizci.starter.controller;

import com.sanemizci.starter.dto.DtoGalleryCars;
import com.sanemizci.starter.dto.DtoGalleryCarsIU;

public interface IRestGalleryCarsController {
    public RootEntity<DtoGalleryCars> saveGalleryCars(DtoGalleryCarsIU dtoGalleryCarsIU);
}
