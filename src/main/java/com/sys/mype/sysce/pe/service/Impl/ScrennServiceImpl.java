package com.sys.mype.sysce.pe.service.Impl;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.ScreenDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceGenericClientException;
import com.sys.mype.sysce.pe.model.BScreen;
import com.sys.mype.sysce.pe.repository.ScreenRepository;
import com.sys.mype.sysce.pe.service.ScreenService;
import com.sys.mype.sysce.pe.util.Util;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ScrennServiceImpl implements ScreenService {

    final private ScreenRepository screenRepository;

    public ScrennServiceImpl(ScreenRepository screenRepository) {
        this.screenRepository = screenRepository;
    }

    @Override
    public void save(ScreenDTO dto) {
        if(!Util.validateEmptyField(dto.getName()))
            throw new SysceGenericClientException("ingrese el nombre", HttpStatus.BAD_REQUEST);
        BScreen bScreen=new BScreen();
        bScreen.setScreenName(dto.getName());
        bScreen.setScreenDescription(dto.getDescription());
        bScreen.setScreenCode(dto.getCode());
        bScreen.setScreenIcon(dto.getIcon());
        bScreen.setScreenStatus(SysceConstant.STATE_ACTIVE);
        this.screenRepository.save(bScreen);
    }
}
