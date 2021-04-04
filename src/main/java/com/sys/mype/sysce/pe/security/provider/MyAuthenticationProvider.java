package com.sys.mype.sysce.pe.security.provider;

import com.sys.mype.sysce.pe.dto.UserPrincipalDTO;
import com.sys.mype.sysce.pe.errorhandler.SysceEntityNotFoundException;
import com.sys.mype.sysce.pe.model.BAuthority;
import com.sys.mype.sysce.pe.model.BUser;
import com.sys.mype.sysce.pe.service.SipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class MyAuthenticationProvider implements UserDetailsService {

    Logger logger= LoggerFactory.getLogger(MyAuthenticationProvider.class);

    @Autowired
    private SipService sipService;

    @Override
    public UserDetails loadUserByUsername(String s) throws SysceEntityNotFoundException {
        logger.info(s);
        String[] userAndRuc= StringUtils.split(s,String.valueOf(Character.LINE_SEPARATOR));
        logger.info(userAndRuc[0]+' '+userAndRuc[1]);
        BUser bUser=this.sipService.findById(userAndRuc[0]);
        List<BAuthority> authorities=new ArrayList<BAuthority>();
        logger.info("estoy en el provider...!!!" +bUser.getUserPassword());
        UserPrincipalDTO user=new UserPrincipalDTO(bUser.getUserId(),userAndRuc[1],bUser.getUserPassword(),bUser.getUserName(),convertStringToBoolean(bUser.getUserStatus()),authorities,null);
        logger.info("anted del retorno...!!!");
        return user;
    }

    private static boolean convertStringToBoolean(String status){
        boolean rpta=false;
        if(status=="S")
            rpta= true;
        if(status=="N")
            rpta= false;
        return rpta;
    }
}
