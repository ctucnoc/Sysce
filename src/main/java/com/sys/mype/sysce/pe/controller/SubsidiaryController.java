package com.sys.mype.sysce.pe.controller;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.MessageDTO;
import com.sys.mype.sysce.pe.dto.SubsidiaryDTO;
import com.sys.mype.sysce.pe.service.SubsidiaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(SysceConstant.PATH_SYSCE_APP_SUBSIDIARY)
@CrossOrigin(SysceConstant.PATH_FROTEND_SYSCE)
public class SubsidiaryController {

    final private SubsidiaryService subsidiaryService;

    public SubsidiaryController(SubsidiaryService subsidiaryService) {
        this.subsidiaryService = subsidiaryService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody SubsidiaryDTO dto){
        this.subsidiaryService.save(dto);
        return new ResponseEntity<>(new MessageDTO("Subsidiaria Registrado"),HttpStatus.CREATED);
    }
}
