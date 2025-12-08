package com.sanemizci.starter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoGalleryCars extends DtoBase{

    private DtoGallery gallery;

    private DtoCar car;
}
