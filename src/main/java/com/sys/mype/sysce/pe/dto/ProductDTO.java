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

    public void switchToUppercase(){
    this.productName = this.productName.toUpperCase();
    this.productNameSummary = this.productNameSummary.toUpperCase();
    }

}
