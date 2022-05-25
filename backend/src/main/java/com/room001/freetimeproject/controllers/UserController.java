package com.room001.freetimeproject.controllers;

import com.room001.freetimeproject.Dtos.LoginRequestDTO;
import com.room001.freetimeproject.Dtos.RegisterNewUser;
import com.room001.freetimeproject.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@RestController
public class UserController {


    private IUserService iUserService;

    @Autowired
    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

//================Main Page=================
    @PostMapping("/free_time")
    public ResponseEntity MainPage(@RequestBody LoginRequestDTO loginRequestDTO){

        iUserService.LogUser(loginRequestDTO);
        return new ResponseEntity(HttpStatus.OK);


    }
//================Register=================

    @PostMapping("/register")
    public ResponseEntity RegisterNewUser(@RequestBody RegisterNewUser registerNewUser){

        iUserService.RegisterNewUser(registerNewUser);
        return new ResponseEntity(HttpStatus.OK);
    }
}
