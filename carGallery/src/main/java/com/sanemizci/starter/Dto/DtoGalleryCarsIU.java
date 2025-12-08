package com.sanemizci.starter.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoGalleryCarsIU {
    @NotNull
    private Long galleryId;
    @NotNull
    private Long carId;
}
