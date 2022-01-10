package com.backend.lmsapi.model;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.type.TrueFalseType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.FlashMapManager;

import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "tbl_user")
public class User implements UserDetails {

    @Id
    private String id;
    private String name;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private Boolean isLocked;
    private Boolean isEnabled;

    

    public User(String name, String username, String email, String password, UserRole userRole, Boolean isLocked, Boolean isEnabled) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
        this.isLocked = isLocked;
        this.isEnabled = isEnabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(UserRole.name());
        return Collections.singletonList(authority);
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
        return !isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
    
}
