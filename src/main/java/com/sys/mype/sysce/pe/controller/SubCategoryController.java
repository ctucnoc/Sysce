package com.sys.mype.sysce.pe.controller;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.SubCategoryDTO;
import com.sys.mype.sysce.pe.service.SubCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(SysceConstant.RESOURCE_SUBCATEGORYS)
@CrossOrigin(SysceConstant.PATH_FROTEND_SYSCE)
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @PostMapping(SysceConstant.RESOURCE_SUBCATEGORYS_SUBCATEGORY)
    public ResponseEntity<?> save(@RequestBody SubCategoryDTO subCategoryDTO){
        this.subCategoryService.save(subCategoryDTO);
        return new ResponseEntity<>("", HttpStatus.ACCEPTED);
    }
}
