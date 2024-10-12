package com.app_manager.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    
    UserEntity findByUsername(String username);

    UserEntity findByEmail(String email);

    List<UserEntity> findByName(String name);
}
