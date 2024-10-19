package com.app_manager.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app_manager.security.JwtUser;
import com.app_manager.user.UserEntity;
import com.app_manager.user.UserService;
import com.app_manager.util.StringUtils;

@Service
public class UserDetailsValidate implements UserDetailsService {

    private final UserService userService;

    public UserDetailsValidate(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity;

        if(StringUtils.isEmail(username))
            userEntity = userService.findByEmail(username);

        else   
            userEntity = userService.findByUsername(username);
        
        if(userEntity == null || userEntity.getUsername() == "") {
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }
        
        return new JwtUser(userEntity.getUsername(), userEntity.getPassword(), userEntity.getRole());
    }

    
}
