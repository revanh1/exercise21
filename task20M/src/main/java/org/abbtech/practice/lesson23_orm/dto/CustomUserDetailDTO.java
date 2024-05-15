package org.abbtech.practice.lesson23_orm.dto;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.abbtech.practice.lesson23_orm.model.UserInfo;
import org.abbtech.practice.lesson23_orm.model.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetailDTO implements UserDetails {
    private final String username;
    private final String password;
    private final Set<? extends GrantedAuthority> authorities;

    public CustomUserDetailDTO(UserInfo byUsername) {
        this.username = byUsername.getUsername();
        this.password = byUsername.getPassword();
        Set<GrantedAuthority> auths = new HashSet<>();
        for (UserRole role : byUsername.getUserRoles()) {
            auths.add(new SimpleGrantedAuthority(role.getRole().toUpperCase()));
        }
        this.authorities = auths;
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
        return username;
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
