package com.sys.mype.sysce.pe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnterpriseDTO {
    private int id;
    private String name;
    private String img;
    private String address;
    private String phone;
    private String ruc;
    private String mail;
}
