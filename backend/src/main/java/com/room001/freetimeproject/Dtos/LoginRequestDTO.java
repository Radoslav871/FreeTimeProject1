package com.room001.freetimeproject.Dtos;

public class LoginRequestDTO {

    public String email;
    public String password;

    public LoginRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
