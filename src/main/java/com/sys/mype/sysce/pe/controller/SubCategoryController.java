package com.sys.mype.sysce.pe.controller;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.MessageDTO;
import com.sys.mype.sysce.pe.dto.SubCategoryDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceGenericClientException;
import com.sys.mype.sysce.pe.service.SubCategoryService;
import com.sys.mype.sysce.pe.util.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(SysceConstant.PATH_SYSCE_APP_SUBCATEGORY)
@CrossOrigin(SysceConstant.PATH_FROTEND_SYSCE)
public class SubCategoryController {

    private SubCategoryService subCategoryService;

    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody SubCategoryDTO subCategoryDTO){
        this.subCategoryService.save(subCategoryDTO);

        return new ResponseEntity<>(new MessageDTO("Sub categoria registrada"), HttpStatus.ACCEPTED);
    }
}
