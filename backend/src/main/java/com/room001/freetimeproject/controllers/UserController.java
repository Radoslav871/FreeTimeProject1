package com.room001.freetimeproject.controllers;

import com.room001.freetimeproject.Dtos.JWT.AuthenticationResponse;
import com.room001.freetimeproject.Dtos.User.LoginRequestDTO;
import com.room001.freetimeproject.Dtos.User.RegisterNewUser;
import com.room001.freetimeproject.Util.JwtUtil;
import com.room001.freetimeproject.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private IUserService iUserService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    //================login=================
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity MainPage(@RequestBody LoginRequestDTO loginRequestDTO) throws Exception {

        final UserDetails userDetails = iUserService.LoginCheck(loginRequestDTO);

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    //================Register=================
    @PostMapping("/register/user")
    public ResponseEntity RegisterNewUser(@RequestBody RegisterNewUser registerNewUser) throws Exception {

        iUserService.RegisterNewUser(registerNewUser);
        return new ResponseEntity(HttpStatus.OK);
    }

    //================test=================
    @PostMapping("/help")
    public String Hello() {
        return "You did it";
    }
}
