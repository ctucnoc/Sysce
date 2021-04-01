package com.sys.mype.sysce.pe.service.Impl;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.SubsidiaryDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceGenericClientException;
import com.sys.mype.sysce.pe.model.BEnterprise;
import com.sys.mype.sysce.pe.model.BSubsidiary;
import com.sys.mype.sysce.pe.repository.SubsidiaryRepository;
import com.sys.mype.sysce.pe.service.SubsidiaryService;
import com.sys.mype.sysce.pe.util.Util;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SubsidiaryServiceImpl implements SubsidiaryService {

    final private SubsidiaryRepository subsidiaryRepository;

    public SubsidiaryServiceImpl(SubsidiaryRepository subsidiaryRepository) {
        this.subsidiaryRepository = subsidiaryRepository;
    }

    @Override
    public void save(SubsidiaryDTO dto) {
        if (!Util.validateEmptyField(dto.getName()))
            throw new SysceGenericClientException("Por Favor, Ingrese un nombre", HttpStatus.BAD_REQUEST);
        if(dto.getEnterpriseId()<=0)
            throw new SysceGenericClientException("Por Favor, Ingrese una empresa", HttpStatus.BAD_REQUEST);
        BSubsidiary bSubsidiary=new BSubsidiary();
        BEnterprise bEnterprise=new BEnterprise();
        bEnterprise.setEnterpriseId(dto.getEnterpriseId());
        bSubsidiary.setSubsidiaryAddress(dto.getAddress());
        bSubsidiary.setSubsidiaryName(dto.getName());
        bSubsidiary.setSubsidiaryNumberPhone(dto.getPhone());
        bSubsidiary.setSubsidiaryStatus(SysceConstant.STATE_ACTIVE);
        bSubsidiary.setBEnterprise(bEnterprise);
        this.subsidiaryRepository.save(bSubsidiary);
    }

    @Override
    public List<SubsidiaryDTO> findAllByEnterpriseId(int id) {
        return this.subsidiaryRepository.findAllByEnterpriseId(id,SysceConstant.STATE_ACTIVE).stream().map((bean)->
            new SubsidiaryDTO(bean.getSubsidiaryId(),bean.getSubsidiaryName(),bean.getSubsidiaryAddress(),bean.getSubsidiaryNumberPhone(),bean.getBEnterprise().getEnterpriseId())
        ).collect(Collectors.toList());
    }
}
