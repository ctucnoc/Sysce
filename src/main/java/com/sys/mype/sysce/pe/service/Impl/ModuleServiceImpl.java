package com.sys.mype.sysce.pe.service.Impl;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.ModuleDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceGenericClientException;
import com.sys.mype.sysce.pe.model.BModule;
import com.sys.mype.sysce.pe.repository.ModuleRepository;
import com.sys.mype.sysce.pe.service.ModuleService;
import com.sys.mype.sysce.pe.util.Util;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ModuleServiceImpl implements ModuleService {

    final private ModuleRepository moduleRepository;

    public ModuleServiceImpl(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @Override
    public void save(ModuleDTO dto) {
        if(!Util.validateEmptyField(dto.getName()))
            throw new SysceGenericClientException("Ingrese un nombre", HttpStatus.MULTI_STATUS.BAD_REQUEST);
        if(!Util.validateEmptyField(dto.getCode()))
            throw new SysceGenericClientException("Ingrese un codigo", HttpStatus.MULTI_STATUS.BAD_REQUEST);
        BModule bean=new BModule();
        bean.setModuleName(dto.getName());
        bean.setModuleDescription(dto.getDescription());
        bean.setModuleCode(dto.getCode());
        bean.setModuleIcon(dto.getIcon());
        bean.setModuleStatus(SysceConstant.STATE_ACTIVE);
        this.moduleRepository.save(bean);
    }
}
