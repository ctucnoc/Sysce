package com.sys.mype.sysce.pe.controller;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.SubsidiaryDTO;
import com.sys.mype.sysce.pe.service.SubsidiaryService;
import com.sys.mype.sysce.pe.util.CRUD;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(SysceConstant.RESOURCE_SUBSIDIARYS)
@CrossOrigin(SysceConstant.PATH_FROTEND_SYSCE)
public class SubsidiaryController extends GenericController{

    final SubsidiaryService subsidiaryService;

    public SubsidiaryController(SubsidiaryService subsidiaryService) {
        this.subsidiaryService = subsidiaryService;
    }

    @PostMapping(SysceConstant.RESOURCE_SUBSIDIARYS_SUBSIDIARY)
    public ResponseEntity<?> add(@Valid @RequestBody SubsidiaryDTO dto){
        return super.ok(this.subsidiaryService.save(dto), CRUD.REGISTER);
    }
    
    @PostMapping(SysceConstant.RESOURCE_SUBSIDIARYS_SUBSIDIARY+"/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody SubsidiaryDTO dto,@PathVariable int id){
        return super.ok(this.subsidiaryService.update(dto,id), CRUD.UPDATE);
    }
    
    @PatchMapping(SysceConstant.RESOURCE_SUBSIDIARYS_SUBSIDIARY+"/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return super.ok(this.subsidiaryService.delete(id), CRUD.DELETE);
    }

    @GetMapping(SysceConstant.RESOURCE_SUBSIDIARYS_SUBSIDIARY+"/{id}")
    public ResponseEntity<?> findAllByEnterpriseId(@PathVariable int id){
        return super.ok(this.subsidiaryService.findAllByEnterpriseId(id), CRUD.FIND);
    }
}
