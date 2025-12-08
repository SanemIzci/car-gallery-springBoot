package com.sanemizci.starter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoGallery extends DtoBase {

    private String firstName;

    private String lastName;

    private Long address_id;
    
    private DtoAddress address;
}
