package com.app_manager.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    
    private String name;
    private String username;
    private String email;
    private String password;
    private String role;

    public UserEntity toUserEntity() {

        return new UserEntity(
            this.username,
            this.name,
            this.email,
            this.password,
            this.role
        );
    }
}
