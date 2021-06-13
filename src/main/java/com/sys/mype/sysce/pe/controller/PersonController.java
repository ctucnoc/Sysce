package com.sys.mype.sysce.pe.controller;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.MessageDTO;
import com.sys.mype.sysce.pe.dto.PersonDTO;
import com.sys.mype.sysce.pe.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(SysceConstant.RESOURCE_PERSONS)
@CrossOrigin(SysceConstant.PATH_FROTEND_SYSCE)
public class PersonController {

    final private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(SysceConstant.RESOURCE_PERSONS_PERSON)
    public ResponseEntity<?> add(@RequestBody PersonDTO dto){
        this.personService.save(dto);
        return new ResponseEntity<>(new MessageDTO("Persona registrado con exito"), HttpStatus.CREATED);
    }
}
