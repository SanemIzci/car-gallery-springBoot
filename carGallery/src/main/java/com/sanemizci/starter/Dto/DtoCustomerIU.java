package com.sanemizci.starter.Dto;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class DtoCustomerIU {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String tckn;
    @NotNull
    private Date dateOfBirth;
    @NotNull
    private Long address_id;
    @NotNull
    private Long account_id;
}
