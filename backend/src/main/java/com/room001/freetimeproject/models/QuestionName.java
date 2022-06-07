package com.room001.freetimeproject.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String NameOfTheQuestion;

    @OneToMany
    List<QuestionImage> questionImage;
}
