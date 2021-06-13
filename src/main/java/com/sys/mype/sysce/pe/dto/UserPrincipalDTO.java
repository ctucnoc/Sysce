package com.sys.mype.sysce.pe.dto;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
public class UserPrincipalDTO implements UserDetails {
    private String id;
    private String ruc;
    private String password;
    private String name;
    private boolean status;
    private Collection<? extends GrantedAuthority> authorities;
    private List<SubsidiaryInitDTO> subsidiaries;
    private Date lastPasswordResetDate;
    private List<NavItemDTO> navItems;

    public UserPrincipalDTO(String id, String ruc, String password, String name, boolean status, Collection<? extends GrantedAuthority> authorities,List<SubsidiaryInitDTO> subsidiaries, Date lastPasswordResetDate,List<NavItemDTO> navItems ){
        this.id=id;
        this.ruc=ruc;
        this.password=password;
        this.name=name;
        this.status=status;
        this.authorities=authorities;
        this.subsidiaries=subsidiaries;
        this.navItems=navItems;
    }
    
    public List<NavItemDTO> getNavItems(){
    	return navItems;
    }

    public List<SubsidiaryInitDTO> getSubsidiaries(){
    	return subsidiaries;
    }

    public String getName(){
        return name;
    }

    public Date getLastPasswordResetDate(){
        return lastPasswordResetDate;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
