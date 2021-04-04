package com.sys.mype.sysce.pe.controller;

import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.MessageDTO;
import com.sys.mype.sysce.pe.dto.UserDTO;
import com.sys.mype.sysce.pe.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(SysceConstant.PATH_SYSCE_APP_USER)
@CrossOrigin(SysceConstant.PATH_FROTEND_SYSCE)
public class UserController {

    final private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody UserDTO dto){
        this.userService.save(dto);
        return new ResponseEntity<>(new MessageDTO(String.format("Usuaurio %s creado", dto.getId())),HttpStatus.CREATED);
    }
}
