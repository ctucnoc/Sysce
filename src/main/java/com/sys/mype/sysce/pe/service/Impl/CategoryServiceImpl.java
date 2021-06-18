package com.sys.mype.sysce.pe.service.Impl;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.CategoryDTO;
import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.dto.request.CategoryRequestDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceEntityNotFoundException;
import com.sys.mype.sysce.pe.model.BCategory;
import com.sys.mype.sysce.pe.repository.CategoryRepository;
import com.sys.mype.sysce.pe.service.CategoryService;
import com.sys.mype.sysce.pe.util.SysceResources;
import com.sys.mype.sysce.pe.util.Util;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public HrefEntityDTO save(CategoryRequestDTO categoryDTO) {
        BCategory bCategory = new BCategory();
        bCategory.setCategoryDescription(categoryDTO.getDescription());
        bCategory.setCategoryStatus(SysceConstant.STATE_ACTIVE);
        this.categoryRepository.save(bCategory);
        return Util.createHrefFromResource(bCategory.getCategoryId(), SysceResources.CATEGORY);
    }

	@Override
	public CategoryDTO findById(int id) {
		BCategory bCategory=this.categoryRepository.findByIdAndState(id, SysceConstant.STATE_ACTIVE).orElseThrow(()-> new SysceEntityNotFoundException("not fount category"));
		CategoryDTO categoryDTO=new CategoryDTO();
		categoryDTO.setDescription(bCategory.getCategoryDescription());
		categoryDTO.setId(bCategory.getCategoryId());
		return categoryDTO;
	}

	@Override
	public List<CategoryDTO> findByDescription(String key_word) {
		return this.categoryRepository.findByCategoryDescriptionAndCategoryStatus(key_word, SysceConstant.STATE_ACTIVE)
				.stream()
				.map((bean)-> new CategoryDTO(bean.getCategoryId(), bean.getCategoryDescription()))
				.collect(Collectors.toList());
	}

	@Override
	public HrefEntityDTO update(CategoryDTO categoryDTO, int id) {
		BCategory bCategory=this.categoryRepository.findByIdAndState(id, SysceConstant.STATE_ACTIVE).orElseThrow(()-> new SysceEntityNotFoundException("not fount category"));
		bCategory.setCategoryDescription(categoryDTO.getDescription());
		this.categoryRepository.save(bCategory);
		return Util.createHrefFromResource(bCategory.getCategoryId(), SysceResources.CATEGORY);
	}
}
