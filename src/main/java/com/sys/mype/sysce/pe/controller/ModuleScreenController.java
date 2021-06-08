package com.sys.mype.sysce.pe.controller;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.MessageDTO;
import com.sys.mype.sysce.pe.dto.ModuleScreenDTO;
import com.sys.mype.sysce.pe.service.ModuleScreenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(SysceConstant.PATH_SYSCE_APP_MODULE_SCREEN)
@CrossOrigin(SysceConstant.PATH_FROTEND_SYSCE)
public class ModuleScreenController {
    final private ModuleScreenService moduleScreenService;

    public ModuleScreenController(ModuleScreenService moduleScreenService) {
        this.moduleScreenService = moduleScreenService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ModuleScreenDTO dto){
        this.moduleScreenService.save(dto);
        return new ResponseEntity<>(new MessageDTO("Correctamente registrado"), HttpStatus.CREATED);
    }
}
