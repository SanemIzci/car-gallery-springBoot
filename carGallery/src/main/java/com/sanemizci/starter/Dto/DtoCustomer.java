package com.sanemizci.starter.Dto;

import jakarta.persistence.Column;

import java.util.Date;

public class DtoCustomer extends DtoBase {

    private String firstName;

    private String lastName;

    private String tckn;

    private Date dateOfBirth;

    private Long address_id;

    private Long account_id;
}
