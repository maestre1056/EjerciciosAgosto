package com.bosonit.ej15.security.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class AuthCredentials {
    private String username;
    private String password;
    private Collection<GrantedAuthority> roles = new ArrayList<>();

}
