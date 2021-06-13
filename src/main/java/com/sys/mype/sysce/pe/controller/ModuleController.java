package com.sys.mype.sysce.pe.controller;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.MessageDTO;
import com.sys.mype.sysce.pe.dto.ModuleDTO;
import com.sys.mype.sysce.pe.service.ModuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(SysceConstant.RESOURCE_MODULES)
@CrossOrigin(SysceConstant.PATH_FROTEND_SYSCE)
public class ModuleController {

    final private ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ModuleDTO dto){
        this.moduleService.save(dto);
        return new ResponseEntity<>(new MessageDTO("correctamente registrado"), HttpStatus.CREATED);
    }
}
