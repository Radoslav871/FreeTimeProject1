package com.room001.freetimeproject.services;

import com.room001.freetimeproject.Dtos.User.LoginRequestDTO;
import com.room001.freetimeproject.Dtos.User.RegisterNewUser;
import com.room001.freetimeproject.Util.MyUserDetailsService;
import com.room001.freetimeproject.models.UserModel;
import com.room001.freetimeproject.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private UserRepositories userRepositories;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    public UserService(@Qualifier("userRepo") UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    @Override
    public void RegisterNewUser(RegisterNewUser registerNewUser) {

        // add check if user already exist email & password is correct format
        userRepositories.save(new UserModel(registerNewUser.nickName, registerNewUser.email, registerNewUser.password, 0));
    }

    @Override
    public UserDetails LoginCheck(LoginRequestDTO loginRequestDTO) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.userName, loginRequestDTO.password));

        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequestDTO.userName);

        return userDetails;
    }
}
