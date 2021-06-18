package com.sys.mype.sysce.pe.service.Impl;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.HrefEntityDTO;
import com.sys.mype.sysce.pe.dto.SubsidiaryDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceEntityNotFoundException;
import com.sys.mype.sysce.pe.model.BEnterprise;
import com.sys.mype.sysce.pe.model.BSubsidiary;
import com.sys.mype.sysce.pe.repository.EnterpriseRepository;
import com.sys.mype.sysce.pe.repository.SubsidiaryRepository;
import com.sys.mype.sysce.pe.service.SubsidiaryService;
import com.sys.mype.sysce.pe.util.SysceResources;
import com.sys.mype.sysce.pe.util.Util;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SubsidiaryServiceImpl implements SubsidiaryService {

    final SubsidiaryRepository subsidiaryRepository;
    final EnterpriseRepository enterpriseRepository;

    public SubsidiaryServiceImpl(SubsidiaryRepository subsidiaryRepository,EnterpriseRepository enterpriseRepository) {
        this.subsidiaryRepository = subsidiaryRepository;
        this.enterpriseRepository=enterpriseRepository;
    }

    @Override
    public HrefEntityDTO save(SubsidiaryDTO dto) {
    	BEnterprise bEnterprise=enterpriseRepository.findById(dto.getEnterpriseId()).orElseThrow(()-> new SysceEntityNotFoundException("not found enterprise"));
        BSubsidiary bSubsidiary=new BSubsidiary();
        bEnterprise.setEnterpriseId(dto.getEnterpriseId());
        bSubsidiary.setSubsidiaryAddress(dto.getAddress());
        bSubsidiary.setSubsidiaryName(dto.getName());
        bSubsidiary.setSubsidiaryNumberPhone(dto.getPhone());
        bSubsidiary.setSubsidiaryStatus(SysceConstant.STATE_ACTIVE);
        bSubsidiary.setBEnterprise(bEnterprise);
        this.subsidiaryRepository.save(bSubsidiary);
        return Util.createHrefFromResource(bSubsidiary.getSubsidiaryId(), SysceResources.ENTERPRISE);
    }

    @Override
    public List<SubsidiaryDTO> findAllByEnterpriseId(int id) {
        return this.subsidiaryRepository.findAllByEnterpriseId(id,SysceConstant.STATE_ACTIVE).stream().map((bean)->
            new SubsidiaryDTO(
                    bean.getSubsidiaryId(),
                    bean.getSubsidiaryName(),
                    bean.getSubsidiaryAddress(),
                    bean.getSubsidiaryNumberPhone(),
                    bean.getBEnterprise().getEnterpriseId())
        ).collect(Collectors.toList());
    }

	@Override
	public HrefEntityDTO update(SubsidiaryDTO dto, int id) {
    	BSubsidiary bSubsidiary=subsidiaryRepository.findById(id).orElseThrow(()-> new SysceEntityNotFoundException("not found subsidiary"));
    	BEnterprise bEnterprise=enterpriseRepository.findById(dto.getEnterpriseId()).orElseThrow(()-> new SysceEntityNotFoundException("not found enterprise"));
    	bSubsidiary.setSubsidiaryAddress(dto.getAddress());
    	bSubsidiary.setSubsidiaryName(dto.getName());
    	bSubsidiary.setSubsidiaryNumberPhone(dto.getPhone());
    	bSubsidiary.setBEnterprise(bEnterprise);
    	this.subsidiaryRepository.save(bSubsidiary);
    	return Util.createHrefFromResource(bSubsidiary.getSubsidiaryId(), SysceResources.SUBSIDIARY);
	}

	@Override
	public HrefEntityDTO delete(int id) {
    	BSubsidiary bSubsidiary=subsidiaryRepository.findById(id).orElseThrow(()-> new SysceEntityNotFoundException("not found subsidiary"));
    	bSubsidiary.setSubsidiaryStatus(SysceConstant.STATE_INACTIVE);
    	this.subsidiaryRepository.save(bSubsidiary);
		return Util.createHrefFromResource(bSubsidiary.getSubsidiaryId(), SysceResources.SUBSIDIARY);
	}
}
