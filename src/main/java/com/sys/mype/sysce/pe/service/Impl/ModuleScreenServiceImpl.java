package com.sys.mype.sysce.pe.service.Impl;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.ModuleScreenDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceEntityNotFoundException;
import com.sys.mype.sysce.pe.model.BModule;
import com.sys.mype.sysce.pe.model.BModuleScreen;
import com.sys.mype.sysce.pe.model.BScreen;
import com.sys.mype.sysce.pe.repository.ModuleRepository;
import com.sys.mype.sysce.pe.repository.ModuleScreenRepository;
import com.sys.mype.sysce.pe.repository.ScreenRepository;
import com.sys.mype.sysce.pe.service.ModuleScreenService;
import com.sys.mype.sysce.pe.service.ModuleService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ModuleScreenServiceImpl implements ModuleScreenService {

    final private ModuleScreenRepository moduleScreenRepository;
    final private ModuleRepository moduleRepository;
    final private ScreenRepository screenRepository;

    public ModuleScreenServiceImpl(ModuleScreenRepository moduleScreenRepository,ModuleRepository moduleRepository,ScreenRepository screenRepository) {
        this.moduleScreenRepository = moduleScreenRepository;
        this.moduleRepository=moduleRepository;
        this.screenRepository=screenRepository;
    }

    @Override
    public void save(ModuleScreenDTO dto) {
        BModule bModule=this.moduleRepository.findById(dto.getModuleId()).orElseThrow(()-> new SysceEntityNotFoundException("Id no encontrado'"));
        BScreen bScreen=this.screenRepository.findById(dto.getScreenId()).orElseThrow(()-> new SysceEntityNotFoundException("Id no encontrado'"));
        BModuleScreen bModuleScreen=new BModuleScreen();
        bModuleScreen.setBModule(bModule);
        bModuleScreen.setBScreen(bScreen);
        bModuleScreen.setModuleScreenStatus(SysceConstant.STATE_ACTIVE);
        this.moduleScreenRepository.save(bModuleScreen);
    }
}
