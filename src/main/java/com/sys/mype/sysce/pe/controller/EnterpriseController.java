package com.sys.mype.sysce.pe.controller;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.EnterpriseDTO;
import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.dto.request.EnterpriseRequestDTO;
import com.sys.mype.sysce.pe.service.EnterpriseService;
import com.sys.mype.sysce.pe.util.CRUD;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping(SysceConstant.RESOURCE_ENTERPRISES)
@CrossOrigin(SysceConstant.PATH_FROTEND_SYSCE)
public class EnterpriseController extends GenericController{

    final private EnterpriseService enterpriseService;

    public EnterpriseController(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    @PostMapping(SysceConstant.RESOURCE_ENTERPRISES_ENTERPRISE)
    public ResponseEntity<?> add(@Valid @RequestBody EnterpriseRequestDTO dto){
        return super.ok(this.enterpriseService.save(dto), CRUD.REGISTER);
    }

    @PutMapping(SysceConstant.RESOURCE_ENTERPRISES_ENTERPRISE+"/{id}")
    public ResponseEntity<HrefEntityDTO> update(@PathVariable int id,@RequestBody EnterpriseRequestDTO dto){
        return new ResponseEntity<>(this.enterpriseService.update(id,dto),HttpStatus.OK);
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
