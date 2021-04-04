package com.sys.mype.sysce.pe.service.Impl;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.PersonDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceGenericClientException;
import com.sys.mype.sysce.pe.model.BGender;
import com.sys.mype.sysce.pe.model.BPerson;
import com.sys.mype.sysce.pe.repository.PersonRepository;
import com.sys.mype.sysce.pe.service.PersonService;
import com.sys.mype.sysce.pe.util.Util;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    final private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void save(PersonDTO dto) {
        if(!Util.validateEmptyField(dto.getName()))
            throw new SysceGenericClientException("Por Favor, Ingrese un nombre", HttpStatus.BAD_REQUEST);
        if(!Util.validateEmptyField(dto.getDocumentType()))
            throw new SysceGenericClientException("Por Favor, Ingrese Tipo Documento", HttpStatus.BAD_REQUEST);
        if(!Util.validateEmptyField(dto.getDocumentNumber()))
            throw new SysceGenericClientException("Por Favor, Ingrese Nro. Documento", HttpStatus.BAD_REQUEST);
        if(!Util.validateEmptyField(dto.getFirstSurName()))
            throw new SysceGenericClientException("Por Favor, Ingrese primer apellido", HttpStatus.BAD_REQUEST);
        if(!Util.validateEmptyField(dto.getSecondSurName()))
            throw new SysceGenericClientException("Por Favor, Ingrese secundo apellido", HttpStatus.BAD_REQUEST);
        BPerson bPerson=new BPerson();
        BGender bGender=new BGender();
        bGender.setGenderId(dto.getGenderId());
        bPerson.setPersonName(dto.getName().toUpperCase());
        bPerson.setPersonAddress(dto.getAddress().toUpperCase());
        bPerson.setPersonDocumentNumber(dto.getDocumentNumber());
        bPerson.setPersonDocumentType(dto.getDocumentType());
        bPerson.setPersonFirstSurName(dto.getFirstSurName().toUpperCase());
        bPerson.setPersonSecondSurName(dto.getSecondSurName().toUpperCase());
        bPerson.setPersonMail(dto.getMail());
        bPerson.setPersonDateBirth(dto.getDateBirth());
        bPerson.setPersonStatus(SysceConstant.STATE_ACTIVE);
        bPerson.setBGender(bGender);
        this.personRepository.save(bPerson);
    }
}
