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
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String email;
    // need to hash password
    private String password;
    private int points;

    public UserModel(String username, String email, String password, int points) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.points = points;
    }

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserModel() {
    }
}
