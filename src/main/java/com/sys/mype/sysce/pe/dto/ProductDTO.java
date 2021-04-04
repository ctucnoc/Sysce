package com.sys.mype.sysce.pe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Locale;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String id;
    private String name;
    private String summary;
    private String kit;
    private String generic;
    private String batch;
    private String expDate;
    private String refrigeration;
    private String status;
    private int subCategoryId;

}
