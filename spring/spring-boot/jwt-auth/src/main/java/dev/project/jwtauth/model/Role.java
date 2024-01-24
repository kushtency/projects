package dev.project.jwtauth.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public enum Role {
    ROLE_USER;
    public List<SimpleGrantedAuthority> getAuthorities() {
        java.util.List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(this.name()));
        return authorities;
    }
}
