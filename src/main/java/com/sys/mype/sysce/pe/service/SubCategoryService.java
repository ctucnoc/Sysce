package com.sys.mype.sysce.pe.service;

import java.util.List;

import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.dto.SubCategoryDTO;

public interface SubCategoryService {

    public HrefEntityDTO save(SubCategoryDTO subCategoryDTO);
    public List<SubCategoryDTO> findSubCategoryByCategoryId(int categoryId);
}
