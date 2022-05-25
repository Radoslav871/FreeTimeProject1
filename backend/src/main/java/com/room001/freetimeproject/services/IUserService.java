package com.room001.freetimeproject.services;

import com.room001.freetimeproject.Dtos.LoginRequestDTO;
import com.room001.freetimeproject.Dtos.RegisterNewUser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    void RegisterNewUser(RegisterNewUser registerNewUser);

    ResponseEntity LogUser(LoginRequestDTO loginRequestDTO);
}
