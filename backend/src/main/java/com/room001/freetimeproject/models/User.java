package com.room001.freetimeproject.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nick;
    private String email;
    // need to hash password
    private String password;
    private int points;

    public User(String nick, String email, String password, int points) {
        this.nick = nick;
        this.email = email;
        this.password = password;
        this.points = points;
    }

    public User() {

    }
}
