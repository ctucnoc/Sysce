package com.sys.mype.sysce.pe.dto;

import com.sys.mype.sysce.pe.model.BCategory;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubCategoryDTO {

    private int subCategoryId;
    private String subCategoryDescription;
    private String subCategoryStatus;
    private int categoryId;

}
