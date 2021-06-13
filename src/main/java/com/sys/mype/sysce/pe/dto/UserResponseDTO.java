package com.sys.mype.sysce.pe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
public class UserResponseDTO {
    private String token;
    private String user;
    private String name;
    private String ruc;
    private Collection<? extends GrantedAuthority> authorities;
    private List<SubsidiaryInitDTO> subsidiaries;
    private List<NavItemDTO> navItems;
}
