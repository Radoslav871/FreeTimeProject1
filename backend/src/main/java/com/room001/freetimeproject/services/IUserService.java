package com.room001.freetimeproject.services;

import com.room001.freetimeproject.Dtos.User.LoginRequestDTO;
import com.room001.freetimeproject.Dtos.User.RegisterNewUser;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserService {
    void RegisterNewUser(RegisterNewUser registerNewUser);
    UserDetails LoginCheck(LoginRequestDTO loginRequestDTO) throws Exception;
}
