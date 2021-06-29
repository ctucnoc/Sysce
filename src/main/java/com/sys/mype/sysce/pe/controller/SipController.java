package com.sys.mype.sysce.pe.controller;


import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.dto.UserPrincipalDTO;
import com.sys.mype.sysce.pe.dto.UserResponseDTO;
import com.sys.mype.sysce.pe.dto.request.UserLoinRequestDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceUnauthorizedException;
import com.sys.mype.sysce.pe.security.jwt.JwtProvider;
import com.sys.mype.sysce.pe.util.CRUD;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.Objects;

import javax.validation.Valid;

@RestController
@RequestMapping(SysceConstant.RESOURCE_SIP)
@CrossOrigin(SysceConstant.PATH_FROTEND_SYSCE)
@PreAuthorize("permitAll()")
public class SipController extends GenericController{

    Logger logger= LoggerFactory.getLogger(SipController.class);

    final AuthenticationManager authenticationManager;

    final JwtProvider jwtProvider;


    public SipController(AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoinRequestDTO dto){
        logger.info("Iniciando proceso de login...!!!");
        logger.info(dto.getUser() +' '+dto.getPassword());
        Authentication authentication = authenticate(dto.getUser(),dto.getRuc(), dto.getPassword());
        String jwt = jwtProvider.generateToken(authentication);
        UserPrincipalDTO user = (UserPrincipalDTO) authentication.getPrincipal();
        UserResponseDTO dto1=new UserResponseDTO(jwt,user.getId(),user.getName(),user.getRuc(),user.getAuthorities(),user.getSubsidiaries(),user.getNavItems());        
        return super.ok(dto1,CRUD.LOGIN);
    }

    private Authentication authenticate(String user,String ruc, String password) {
        String userAndRuc=String.format("%s%s%s",user.trim(),String.valueOf(Character.LINE_SEPARATOR),ruc.trim());
        Objects.requireNonNull(userAndRuc, "Usuario no debe ser vacio");
        Objects.requireNonNull(password, "Password no debe ser vacio");
        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userAndRuc, password));
        } catch (DisabledException e) {
            throw new SysceUnauthorizedException(String.format("Usuario con id %s dehabilitado", user.toLowerCase()));
        } catch (BadCredentialsException e) {
            throw new SysceUnauthorizedException(
                    String.format("Credenciales erroneos para el usuario %s", user.toLowerCase()));
        }
    }
}
