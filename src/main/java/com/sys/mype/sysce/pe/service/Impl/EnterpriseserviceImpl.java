package com.sys.mype.sysce.pe.service.Impl;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.EnterpriseDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceEntityNotFoundException;
import com.sys.mype.sysce.pe.errorhandler.SysceGenericClientException;
import com.sys.mype.sysce.pe.model.BEnterprise;
import com.sys.mype.sysce.pe.repository.EnterpriseRepository;
import com.sys.mype.sysce.pe.service.EnterpriseService;
import com.sys.mype.sysce.pe.util.Util;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EnterpriseserviceImpl implements EnterpriseService {

    final
    private EnterpriseRepository enterpriseRepository;

    public EnterpriseserviceImpl(EnterpriseRepository enterpriseRepository) {
        this.enterpriseRepository = enterpriseRepository;
    }

    @Override
    public void save(EnterpriseDTO dto) {
        if (!Util.validateEmptyField(dto.getName()))
            throw new SysceGenericClientException("Por Favor, Ingrese un nombre", HttpStatus.BAD_REQUEST);
        if(!Util.validateEmptyField(dto.getRuc()))
            throw new SysceGenericClientException("Por Favor, Ingrese RUC", HttpStatus.BAD_REQUEST);
        if(!Util.validateEmptyField(dto.getAddress()))
            throw new SysceGenericClientException("Por Favor, Ingrese dirección", HttpStatus.BAD_REQUEST);
        BEnterprise bEnterprise=new BEnterprise();
        bEnterprise.setEnterpriseName(dto.getName());
        bEnterprise.setEnterpriseAddress(dto.getAddress());
        bEnterprise.setEnterpriseImg(dto.getImg());
        bEnterprise.setEnterpriseMail(dto.getMail());
        bEnterprise.setEnterpriseNumberPhone(dto.getPhone());
        bEnterprise.setEnterpriseRuc(dto.getRuc());
        bEnterprise.setEnterpriseStatus(SysceConstant.STATE_ACTIVE);
        this.enterpriseRepository.save(bEnterprise);
    }

    @Override
    public void update(int id,EnterpriseDTO dto) {
        BEnterprise bEnterprise=this.enterpriseRepository.findById(id).orElseThrow(()-> new SysceEntityNotFoundException("registro no encontrado"));
        bEnterprise.setEnterpriseMail(dto.getMail());
        bEnterprise.setEnterpriseNumberPhone(dto.getPhone());
        bEnterprise.setEnterpriseAddress(dto.getAddress());
        bEnterprise.setEnterpriseName(dto.getName());
        this.enterpriseRepository.save(bEnterprise);
    }

    @Override
    public List<EnterpriseDTO> findByName(String name) {
        return this.enterpriseRepository.findByEnterpriseName(name, SysceConstant.STATE_ACTIVE)
                .stream()
                .map(bEnterprise ->
                        new EnterpriseDTO(
                                bEnterprise.getEnterpriseId(),
                                bEnterprise.getEnterpriseName(),
                                bEnterprise.getEnterpriseImg(),
                                bEnterprise.getEnterpriseAddress(),
                                bEnterprise.getEnterpriseNumberPhone(),
                                bEnterprise.getEnterpriseRuc(),
                                bEnterprise.getEnterpriseMail()
                        )).collect(Collectors.toList());
    }

    @Override
    public EnterpriseDTO findById(int id) {
        BEnterprise bEnterprise= this.enterpriseRepository.findById(id).orElseThrow(()->new SysceEntityNotFoundException(String.format("Empresa con %s no encontrado",id)));
        EnterpriseDTO dto=new EnterpriseDTO();
        dto.setId(bEnterprise.getEnterpriseId());
        dto.setAddress(bEnterprise.getEnterpriseAddress());
        dto.setImg(bEnterprise.getEnterpriseImg());
        dto.setMail(bEnterprise.getEnterpriseMail());
        dto.setName(bEnterprise.getEnterpriseName());
        dto.setPhone(bEnterprise.getEnterpriseNumberPhone());
        dto.setRuc(bEnterprise.getEnterpriseRuc());
        return  dto;
    }
}
