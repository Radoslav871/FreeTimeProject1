package com.room001.freetimeproject.services;


import com.room001.freetimeproject.Dtos.User.LoginRequestDTO;
import com.room001.freetimeproject.Dtos.User.RegisterNewUser;
import com.room001.freetimeproject.models.User;
import com.room001.freetimeproject.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private UserRepositories userRepositories;

    @Autowired
    public UserService(@Qualifier("userRepo")UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    @Override
    public void RegisterNewUser(RegisterNewUser registerNewUser) {

        // add check if user already exist email & password is correct format
        userRepositories.save(new User(registerNewUser.nickName, registerNewUser.email, registerNewUser.password, 0));
    }

    @Override
    public ResponseEntity LogUser(LoginRequestDTO loginRequestDTO) {

        // check password and email

        User tempUser = userRepositories.findByEmail(loginRequestDTO.userName);

        if (tempUser != null) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            throw new RuntimeException("User not Found");
        }
    }
}
