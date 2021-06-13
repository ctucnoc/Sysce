package com.sys.mype.sysce.pe.controller;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.MessageDTO;
import com.sys.mype.sysce.pe.dto.ScreenDTO;
import com.sys.mype.sysce.pe.service.ScreenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(SysceConstant.RESOURCE_SCREENS)
@CrossOrigin(SysceConstant.PATH_FROTEND_SYSCE)
public class ScreenController {

    final private ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }

    @PostMapping(SysceConstant.RESOURCE_SCREENS_SCREEN)
    public ResponseEntity<?> add(@RequestBody ScreenDTO dto){
        this.screenService.save(dto);
        return new ResponseEntity<>(new MessageDTO("Correctamente registrado"), HttpStatus.CREATED);
    }
}
