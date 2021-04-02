package com.sys.mype.sysce.pe.controller;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.CategoryDTO;
import com.sys.mype.sysce.pe.dto.MessageDTO;
import com.sys.mype.sysce.pe.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(SysceConstant.PATH_SYSCE_APP_CATEGORY)
@CrossOrigin(SysceConstant.PATH_FROTEND_SYSCE)
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody CategoryDTO categoryDTO){
        this.categoryService.save(categoryDTO);

        return new ResponseEntity<>(new MessageDTO("Categoria registrado"), HttpStatus.CREATED);
    }
}
