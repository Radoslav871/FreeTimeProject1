package com.room001.freetimeproject.repositories;

import com.room001.freetimeproject.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository("userRepo")
public interface UserRepositories extends JpaRepository<UserModel,Long>{
    UserDetails findByUsername(String username);
    UserModel findByUsernameOrEmail(String username,String email);
    UserModel findByEmail(String email);
}
