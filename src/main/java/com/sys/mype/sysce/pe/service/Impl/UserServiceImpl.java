package com.sys.mype.sysce.pe.service.Impl;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.UserDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceGenericClientException;
import com.sys.mype.sysce.pe.model.BPerson;
import com.sys.mype.sysce.pe.model.BUser;
import com.sys.mype.sysce.pe.repository.UserRepository;
import com.sys.mype.sysce.pe.service.UserService;
import com.sys.mype.sysce.pe.util.Util;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    final private PasswordEncoder passwordEncoder;

    final private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public void save(UserDTO dto) {
        if(exitsByUserId(dto.getId()))
            throw new SysceGenericClientException(String.format("Identificador %s ya existe",dto.getId()), HttpStatus.BAD_REQUEST);
        if(!Util.validateEmptyField(dto.getId()))
            throw new SysceGenericClientException("Por Favor, un identificador", HttpStatus.BAD_REQUEST);
        if(!Util.validateEmptyField(dto.getPrivilege()))
            throw new SysceGenericClientException("Por Favor, Ingrese privilegio", HttpStatus.BAD_REQUEST);
        BUser bUser=new BUser();
        BPerson bPerson=new BPerson();
        bPerson.setPersonId(dto.getPersonId());
        bUser.setUserId(dto.getId());
        bUser.setUserName(dto.getName().toUpperCase());
        bUser.setUserPassword(this.passwordEncoder.encode(dto.getId()));
        bUser.setUserPrivilege(dto.getPrivilege());
        bUser.setUserStatus(SysceConstant.STATE_ACTIVE);
        bUser.setBPerson(bPerson);
        this.userRepository.save(bUser);
    }

    public boolean exitsByUserId(String id){
        return this.userRepository.existsById(id);
    }
}
