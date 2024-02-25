package com.atlas.menter.response;

import com.atlas.menter.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Set;

@Data
@AllArgsConstructor
public class AuthenticateUserReponse {
    public String username;
    public String email;
    public Set<Role> roles;
    public boolean enabled;
}
