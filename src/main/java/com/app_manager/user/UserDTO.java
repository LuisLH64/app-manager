package com.app_manager.user;

public record UserDTO(String name, String username, String email, String password, String role) {

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
