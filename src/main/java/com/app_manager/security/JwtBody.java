package com.app_manager.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtBody {
    
    private String token;
    private boolean isValid;

    public JwtBody(String token,
                   boolean isValid)
    {
        this.token = token;
        this.isValid = isValid;
    }
}
