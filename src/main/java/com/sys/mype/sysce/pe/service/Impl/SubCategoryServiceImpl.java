package com.sys.mype.sysce.pe.service.Impl;

import com.sys.mype.sysce.pe.dto.SubCategoryDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceGenericClientException;
import com.sys.mype.sysce.pe.model.BCategory;
import com.sys.mype.sysce.pe.model.BSubCategory;
import com.sys.mype.sysce.pe.repository.SubCategoryRepository;
import com.sys.mype.sysce.pe.service.SubCategoryService;
import com.sys.mype.sysce.pe.util.Util;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SubCategoryServiceImpl implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;

    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    @Override
    public void save(SubCategoryDTO subCategoryDTO) {

        if (!Util.validateEmptyField(subCategoryDTO.getDescription())){
            throw new SysceGenericClientException("Por favor, ingrese una subcateforia", HttpStatus.BAD_REQUEST);
        }

        BSubCategory bSubCategory = new BSubCategory();
        bSubCategory.setSubCategoryDescription(subCategoryDTO.getDescription());
        bSubCategory.setSubCategoryStatus(subCategoryDTO.getStatus());

        BCategory bCategory = new BCategory();
        bCategory.setCategoryId(subCategoryDTO.getCategoryId());
        bSubCategory.setBCategory(bCategory);

        this.subCategoryRepository.save(bSubCategory);


    }
}
