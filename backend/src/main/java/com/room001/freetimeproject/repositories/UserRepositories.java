package com.room001.freetimeproject.repositories;

import com.room001.freetimeproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories extends JpaRepository<User,Long> {
}
