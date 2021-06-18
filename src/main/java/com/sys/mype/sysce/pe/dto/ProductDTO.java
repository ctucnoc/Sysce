package com.sys.mype.sysce.pe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private int subCategoryId;
}
