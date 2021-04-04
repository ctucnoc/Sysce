package com.sys.mype.sysce.pe.dto;

import com.sys.mype.sysce.pe.model.BCategory;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubCategoryDTO {

    private int id;
    private String description;
    private String status;
    private int categoryId;

}
