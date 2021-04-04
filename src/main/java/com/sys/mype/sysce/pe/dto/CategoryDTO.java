package com.sys.mype.sysce.pe.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDTO {

    private int categoryId;
    private String categoryDescription;
    private String categoryStatus;
    private int subsidiaryId;
}
