package com.sys.mype.sysce.pe.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public interface UserAuthorityService {

	public List<GrantedAuthority> findByUserAuthority(String id);
}
