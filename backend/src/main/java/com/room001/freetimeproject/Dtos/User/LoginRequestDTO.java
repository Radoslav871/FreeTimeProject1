package com.room001.freetimeproject.Dtos.User;

public class LoginRequestDTO {

    public String userName;
    public String password;

    public LoginRequestDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
