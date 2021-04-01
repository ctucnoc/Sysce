package com.sys.mype.sysce.pe.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private String productId;
    private String productName;
    private String productNameSummary;
    private String productKit;
    private String productGeneric;
    private String productBatch;
    private String productExpirationDate;
    private String productRefrigeration;
    private String productStatus;
    private int subCategoryId;
}
