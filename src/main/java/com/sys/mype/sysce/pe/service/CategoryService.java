package com.sys.mype.sysce.pe.service;

import java.util.List;

import com.sys.mype.sysce.pe.dto.CategoryDTO;
import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.dto.request.CategoryRequestDTO;

public interface CategoryService {

    public HrefEntityDTO save(CategoryRequestDTO categoryDTO);
    
    public CategoryDTO findById(int id);
    
    public List<CategoryDTO> findByDescription(String key_word);
    
    public HrefEntityDTO update(CategoryDTO categoryDTO,int id);
}
