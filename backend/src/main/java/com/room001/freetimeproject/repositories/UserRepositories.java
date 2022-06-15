package com.room001.freetimeproject.repositories;

import com.room001.freetimeproject.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository("userRepo")
public interface UserRepositories extends JpaRepository<UserModel,Long>{
    UserModel findByUsername(String username);
    UserModel findById(int id);
    UserModel findByUsernameOrEmail(String username,String email);
    UserDetails findByEmail(String email);
}
