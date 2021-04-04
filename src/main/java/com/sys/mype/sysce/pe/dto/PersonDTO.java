package com.sys.mype.sysce.pe.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PersonDTO {
    private int id;
    private String documentType;
    private String documentNumber;
    private String name;
    private String firstSurName;
    private String secondSurName;
    private String address;
    private String mail;
    private Date dateBirth;
    private int genderId;
}
