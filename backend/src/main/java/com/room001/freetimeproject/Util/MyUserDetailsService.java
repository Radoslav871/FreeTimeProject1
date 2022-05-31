package com.room001.freetimeproject.Util;

import com.room001.freetimeproject.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepositories userRepositories;

    public MyUserDetailsService(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetails user = userRepositories.findByUsername(username);

        return new User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }
}