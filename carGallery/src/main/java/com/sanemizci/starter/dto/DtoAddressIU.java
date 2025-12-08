package com.sanemizci.starter.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoAddressIU {
    @NotEmpty
    private String city;
    @NotEmpty
    private String district;
    @NotEmpty
    private String neighborhood;
    @NotEmpty
    private String street;
}
