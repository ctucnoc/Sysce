package com.sys.mype.sysce.pe.service.Impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import com.sys.mype.sysce.pe.constant.SysceConstant;
import com.sys.mype.sysce.pe.errorhandler.SysceEntityUnprocessableException;
import com.sys.mype.sysce.pe.repository.UserAuthorityRepository;
import com.sys.mype.sysce.pe.service.UserAuthorityService;

@Service
public class UserAuthorityServiceImpl implements UserAuthorityService{

	final UserAuthorityRepository userAuthorityRepository;

	public UserAuthorityServiceImpl(UserAuthorityRepository userAuthorityRepository) {
		this.userAuthorityRepository = userAuthorityRepository;
	}

	@Override
	public List<GrantedAuthority> findByUserAuthority(String id) {
		List<GrantedAuthority> list=this.userAuthorityRepository.findByUserAuthority(id,SysceConstant.STATE_ACTIVE)
				.stream()
				.map((userAutority)->new SimpleGrantedAuthority(userAutority.getBAuthority().getAuthorityName())).collect(Collectors.toList());
		if(list.size()==0 || list==null)
			throw new SysceEntityUnprocessableException("no role assigned to the user");
		return list;
	}
	
	
}
