package com.sys.mype.sysce.pe.service.Impl;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.EnterpriseDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceGenericClientException;
import com.sys.mype.sysce.pe.model.BEnterprise;
import com.sys.mype.sysce.pe.repository.EnterpriseRepository;
import com.sys.mype.sysce.pe.service.EnterpriseService;
import com.sys.mype.sysce.pe.util.Util;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

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
}
