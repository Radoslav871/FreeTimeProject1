package com.room001.freetimeproject.services;

import com.room001.freetimeproject.Dtos.User.LoginRequestDTO;
import com.room001.freetimeproject.Dtos.User.RegisterNewUser;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    void RegisterNewUser(RegisterNewUser registerNewUser);
    ResponseEntity LogUser(LoginRequestDTO loginRequestDTO);
}
