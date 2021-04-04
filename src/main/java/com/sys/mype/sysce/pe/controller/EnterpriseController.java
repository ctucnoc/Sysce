package com.sys.mype.sysce.pe.controller;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.EnterpriseDTO;
import com.sys.mype.sysce.pe.dto.MessageDTO;
import com.sys.mype.sysce.pe.service.EnterpriseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(SysceConstant.PATH_SYSCE_APP_ENTERPRISE)
@CrossOrigin(SysceConstant.PATH_FROTEND_SYSCE)
public class EnterpriseController {

    final private EnterpriseService enterpriseService;

    public EnterpriseController(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody EnterpriseDTO dto){
        this.enterpriseService.save(dto);
        return new ResponseEntity<>(new MessageDTO("Empresa Guardado"), HttpStatus.CREATED);
    }

    @GetMapping("/findById/{id}")
    public EnterpriseDTO findById(@PathVariable int id){
        return this.enterpriseService.findById(id);
    }

    @GetMapping("/findByName/{name}")
    public List<EnterpriseDTO> findByName(@PathVariable String name){
        return this.enterpriseService.findByName(name);
    }
}
