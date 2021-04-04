package com.sys.mype.sysce.pe.dto;

import com.sys.mype.sysce.pe.model.BAuthority;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserPrincipalDTO implements UserDetails {
    private String id;
    private String ruc;
    private String password;
    private String name;
    private boolean status;
    private Collection<? extends GrantedAuthority> authorities;
    private Date lastPasswordResetDate;

    public UserPrincipalDTO(String id, String ruc, String password, String name, boolean status, List<BAuthority> list, Date lastPasswordResetDate ){
        this.id=id;
        this.ruc=ruc;
        this.password=password;
        this.name=name;
        this.status=status;
        this.authorities=mapToGrantedAuthorities(list);
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<BAuthority> list){
        return list.stream().map((authority)-> new SimpleGrantedAuthority(authority.getAuthorityName())).collect(Collectors.toList());
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
