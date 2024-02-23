package com.atlas.menter.response;

import com.atlas.menter.entity.Role;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

public class AuthenticateUserReponse {
    public String username;
    public String email;
    public Collection<? extends GrantedAuthority> roles;
    public boolean enabled;
}
