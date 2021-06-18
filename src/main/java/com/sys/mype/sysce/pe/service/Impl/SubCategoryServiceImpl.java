package com.sys.mype.sysce.pe.service.Impl;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.dto.SubCategoryDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceEntityNotFoundException;
import com.sys.mype.sysce.pe.model.BCategory;
import com.sys.mype.sysce.pe.model.BSubCategory;
import com.sys.mype.sysce.pe.repository.CategoryRepository;
import com.sys.mype.sysce.pe.repository.SubCategoryRepository;
import com.sys.mype.sysce.pe.service.SubCategoryService;
import com.sys.mype.sysce.pe.util.SysceResources;
import com.sys.mype.sysce.pe.util.Util;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;

@Service
@Transactional
public class SubCategoryServiceImpl implements SubCategoryService {

    final SubCategoryRepository subCategoryRepository;
    final CategoryRepository categoryRepository;

    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository,CategoryRepository categoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
        this.categoryRepository=categoryRepository;
    }

    @Override
    public HrefEntityDTO save(SubCategoryDTO subCategoryDTO) {
        BCategory bCategory = this.categoryRepository.findById(subCategoryDTO.getCategoryId()).orElseThrow(()-> new SysceEntityNotFoundException("not found category"));
        BSubCategory bSubCategory = new BSubCategory();
        bSubCategory.setSubCategoryDescription(subCategoryDTO.getDescription());
        bSubCategory.setSubCategoryStatus(SysceConstant.STATE_ACTIVE);
        bSubCategory.setBCategory(bCategory);
        this.subCategoryRepository.save(bSubCategory);
        return Util.createHrefFromResource(bSubCategory.getSubCategoryId(), SysceResources.SUBCATEGORY);
    }

	@Override
	public List<SubCategoryDTO> findSubCategoryByCategoryId(int categoryId) {
		return this.subCategoryRepository.findSubCategoryByCategoryId(categoryId, SysceConstant.STATE_ACTIVE)
				.stream()
				.map((bean)->new SubCategoryDTO(bean.getSubCategoryId(), bean.getSubCategoryDescription(), bean.getBCategory().getCategoryId()))
				.collect(Collectors.toList());
	}
}
