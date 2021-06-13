package com.sys.mype.sysce.pe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubsidiaryDTO {
    private int id;
    private String name;
    private String address;
    private String phone;
    private int enterpriseId;
}
