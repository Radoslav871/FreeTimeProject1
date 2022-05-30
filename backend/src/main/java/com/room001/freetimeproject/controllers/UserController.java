package com.room001.freetimeproject.controllers;

import com.room001.freetimeproject.Dtos.User.AuthenticationResponse;
import com.room001.freetimeproject.Dtos.User.LoginRequestDTO;
import com.room001.freetimeproject.Dtos.User.RegisterNewUser;
import com.room001.freetimeproject.Util.JwtRequestFilter;
import com.room001.freetimeproject.Util.JwtUtil;
import com.room001.freetimeproject.Util.MyUserDetailsService;
import com.room001.freetimeproject.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {


    private IUserService iUserService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    //================Main Page=================
    @RequestMapping(value = "/free-time", method = RequestMethod.POST)
    public ResponseEntity MainPage(@RequestBody LoginRequestDTO loginRequestDTO) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.userName, loginRequestDTO.password));

        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = (UserDetails) iUserService.LogUser(loginRequestDTO);

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        iUserService.LogUser(loginRequestDTO);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }
    //================Register=================

    @PostMapping("/register")
    public ResponseEntity RegisterNewUser(@RequestBody RegisterNewUser registerNewUser) {

        iUserService.RegisterNewUser(registerNewUser);
        return new ResponseEntity(HttpStatus.OK);
    }
}
