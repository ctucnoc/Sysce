package com.sys.mype.sysce.pe.service.Impl;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.EnterpriseDTO;
import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.dto.request.EnterpriseRequestDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceEntityNotFoundException;
import com.sys.mype.sysce.pe.errorhandler.SysceGenericClientException;
import com.sys.mype.sysce.pe.model.BEnterprise;
import com.sys.mype.sysce.pe.repository.EnterpriseRepository;
import com.sys.mype.sysce.pe.service.EnterpriseService;
import com.sys.mype.sysce.pe.util.SysceResources;
import com.sys.mype.sysce.pe.util.Util;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EnterpriseserviceImpl implements EnterpriseService {

    final EnterpriseRepository enterpriseRepository;
    final Util util;

    public EnterpriseserviceImpl(EnterpriseRepository enterpriseRepository,Util util) {
        this.enterpriseRepository = enterpriseRepository;
        this.util=util;
    }

    @Override
    public HrefEntityDTO save(EnterpriseRequestDTO dto) {
    	if(!util.validateNumberRUC(dto.getRuc()))
        	throw new SysceGenericClientException("error ruc", HttpStatus.BAD_REQUEST);
    	if(!util.validateEmail(dto.getMail()))
        	throw new SysceGenericClientException("error email", HttpStatus.BAD_REQUEST);
    	if(!util.validateCellphone(dto.getPhone()))
        	throw new SysceGenericClientException("error phone", HttpStatus.BAD_REQUEST);
        if(this.enterpriseRepository.existsByEnterpriseRuc(dto.getRuc(), SysceConstant.STATE_ACTIVE))
        	throw new SysceGenericClientException("exists enterprise", HttpStatus.BAD_REQUEST);
        BEnterprise bEnterprise=new BEnterprise();
        bEnterprise.setEnterpriseName(dto.getName());
        bEnterprise.setEnterpriseAddress(dto.getAddress());
        bEnterprise.setEnterpriseImg(dto.getImg());
        bEnterprise.setEnterpriseMail(dto.getMail());
        bEnterprise.setEnterpriseNumberPhone(dto.getPhone());
        bEnterprise.setEnterpriseRuc(dto.getRuc());
        bEnterprise.setEnterpriseStatus(SysceConstant.STATE_ACTIVE);
        this.enterpriseRepository.save(bEnterprise);
        return Util.createHrefFromResource(bEnterprise.getEnterpriseId(), SysceResources.ENTERPRISE);
    }

    @Override
    public HrefEntityDTO update(int id,EnterpriseRequestDTO dto) {
        BEnterprise bEnterprise=this.enterpriseRepository.findById(id).orElseThrow(()-> new SysceEntityNotFoundException("registro no encontrado"));
        bEnterprise.setEnterpriseMail(dto.getMail());
        bEnterprise.setEnterpriseNumberPhone(dto.getPhone());
        bEnterprise.setEnterpriseAddress(dto.getAddress());
        bEnterprise.setEnterpriseName(dto.getName());
        this.enterpriseRepository.save(bEnterprise);
        return Util.createHrefFromResource(bEnterprise.getEnterpriseId(), SysceResources.ENTERPRISE);
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
