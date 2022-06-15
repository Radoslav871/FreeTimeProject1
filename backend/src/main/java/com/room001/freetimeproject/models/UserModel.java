package com.room001.freetimeproject.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Getter
@Setter
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime registration;
    private LocalDateTime lastVote;
    private String username;
    private String email;
    private String password;
    private int points;

    // add int array (votes) so we can play more than only once pre day

    public UserModel(String username, String email, String password, int points) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.points = points;
        this.registration = LocalDateTime.now();
        this.lastVote = CalculateLastVote();
    }

    private LocalDateTime CalculateLastVote() {
        // after registration minus 1 day so you can play right away
        return LocalDateTime.now().minusDays(1);
    }

    public UserModel() {
    }
}
