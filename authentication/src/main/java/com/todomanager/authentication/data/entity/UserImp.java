package com.todomanager.authentication.data.entity;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserImp implements UserDetails {

    private String password;
    private String userName;
    private List<SimpleGrantedAuthority> role;

    public UserImp(TodoUser user) {
        this.password = user.getPassword();
        this.userName = user.getUsername();
        this.role = Arrays.asList(new SimpleGrantedAuthority(user.getTodoUserRole().getRole()));
    }

    /**
     *
     */
    private static final long serialVersionUID = 5436979087154961191L;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.role;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
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
