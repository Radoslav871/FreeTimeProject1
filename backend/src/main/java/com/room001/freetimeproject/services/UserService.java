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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private UserRepositories userRepositories;
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    public UserService(@Qualifier("userRepo") UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public void RegisterNewUser(RegisterNewUser registerNewUser) throws Exception {

        boolean exist = checkCredentials(registerNewUser);

        registerNewUser.password = this.passwordEncoder.encode(registerNewUser.password);

        userRepositories.save(new UserModel(registerNewUser.userName, registerNewUser.email, registerNewUser.password, 0));
    }

    private boolean checkCredentials(RegisterNewUser registerNewUser) throws Exception {

        if (registerNewUser.userName == null) {
            throw new Exception("you need provide username");
        }

        if (registerNewUser.email == null) {
            throw new Exception("you need provide email");
        }

        if (registerNewUser.password == null) {
            throw new Exception("you need password");
        }

        if (!registerNewUser.email.contains("@")) {
            throw new Exception("not correct format for email");
        }

        UserModel user = null;

        user = userRepositories.findByUsernameOrEmail(registerNewUser.userName, registerNewUser.email);

        if (user != null) {

            if (user.getEmail().equals(registerNewUser.email)) {
                throw new Exception("Email is already taken");
            }

            if (user.getUsername().equals(registerNewUser.userName)) {
                throw new Exception("Username is already taken");
            }
        }

        return true;
    }

    @Override
    public UserDetails LoginCheck(LoginRequestDTO loginRequestDTO) throws Exception {

        UserDetails user = null;

        try {
            user = userRepositories.findByUsername(loginRequestDTO.userName);
            boolean decryptPassword = DecrypPassword(loginRequestDTO,user);

            if (!decryptPassword){
                throw new Exception("Incorrect password");
            }

        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username", e);
        }

        return user;
    }

    private boolean DecrypPassword(LoginRequestDTO loginRequestDTO,UserDetails user) {

        return this.passwordEncoder.matches(loginRequestDTO.password,user.getPassword());
    }
}
