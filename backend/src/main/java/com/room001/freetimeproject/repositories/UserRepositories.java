package com.room001.freetimeproject.repositories;

import com.room001.freetimeproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository("userRepo")
public interface UserRepositories extends JpaRepository<User,Long>{

    User findByEmail(String email);
    UserDetails findByUsername(String username);
}
