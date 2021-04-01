package com.sys.mype.sysce.pe.service.Impl;

import com.sys.mype.sysce.pe.errorhandler.SysceEntityNotFoundException;
import com.sys.mype.sysce.pe.model.BUser;
import com.sys.mype.sysce.pe.repository.SipRepository;
import com.sys.mype.sysce.pe.service.SipService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SipServiceImpl implements SipService {

    final private SipRepository sipRepository;

    public SipServiceImpl(SipRepository sipRepository) {
        this.sipRepository = sipRepository;
    }

    @Override
    public BUser findById(String id) {
        return this.sipRepository.findById(id).orElseThrow(()->new SysceEntityNotFoundException(String.format("Usuario con id %s no encontrado",id)));
    }
}
