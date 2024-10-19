package com.app_manager.user;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public List<UserEntity> findAll() {

        return userRepository.findAll();
    }

    public UserEntity findById(Long id) {

        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
    }

    public List<UserEntity> findByName(String name) {

        return userRepository.findByName(name);
    }

    public UserEntity findByUsername(String username) {

        return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException());
    }

    public UserEntity findByEmail(String email) {

        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException());
    }

    public void insert(UserEntity userEntity) {

        userRepository.save(userEntity);
    }
}
