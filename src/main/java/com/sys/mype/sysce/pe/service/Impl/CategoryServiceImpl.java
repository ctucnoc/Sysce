package com.sys.mype.sysce.pe.service.Impl;

import com.sys.mype.sysce.pe.dto.CategoryDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceGenericClientException;
import com.sys.mype.sysce.pe.model.BCategory;
import com.sys.mype.sysce.pe.model.BSubsidiary;
import com.sys.mype.sysce.pe.repository.CategoryRepository;
import com.sys.mype.sysce.pe.service.CategoryService;
import com.sys.mype.sysce.pe.util.Util;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(CategoryDTO categoryDTO) {

        if (!Util.validateEmptyField(categoryDTO.getCategoryDescription())){
            throw new SysceGenericClientException("Por favor, ingrese una categoria", HttpStatus.BAD_REQUEST);
        }

        BCategory bCategory = new BCategory();
        bCategory.setCategoryDescription(categoryDTO.getCategoryDescription());
        bCategory.setCategoryStatus(categoryDTO.getCategoryStatus());

        BSubsidiary bSubsidiary = new BSubsidiary();
        bSubsidiary.setSubsidiaryId(categoryDTO.getSubsidiaryId());
        bCategory.setBSubsidiary(bSubsidiary);

        this.categoryRepository.save(bCategory);

    }
}
