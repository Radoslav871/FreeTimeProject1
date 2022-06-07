package com.room001.freetimeproject.services;

import com.room001.freetimeproject.Dtos.game.GameResponse;
import com.room001.freetimeproject.models.QuestionImage;
import com.room001.freetimeproject.models.QuestionName;
import com.room001.freetimeproject.repositories.QuestionImageRepositories;
import com.room001.freetimeproject.repositories.QuestionNameRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GameService implements IGameService {

    private QuestionImageRepositories questionImageRepositories;
    private QuestionNameRepositories questionNameRepositories;

    // you have question name class that stores name of game
    // and question image stores path to the picture and id of question name

    @Autowired
    public GameService(QuestionImageRepositories questionImageRepositories, QuestionNameRepositories questionNameRepositories) {
        this.questionImageRepositories = questionImageRepositories;
        this.questionNameRepositories = questionNameRepositories;
    }

    @Override
    public GameResponse StartGame() {

        // add random can't pick 2 images with same id
        // after time is implemented add functionality that you can play max 3 times a day
        // also add check that you will not get same pic in 1 game and then in 2 or 3

        long max = questionImageRepositories.count();
        Random random = new Random();
        List<QuestionImage> questionImages = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            long temp = random.nextInt(1,(int) max);
            questionImages.add(questionImageRepositories.findAllById(temp));
        }

        GameResponse gameResponse = new GameResponse(questionImages);
        return gameResponse;
    }

    @Override
    public void AddGames() {
        // just for adding games into db
        QuestionName questionName = new QuestionName(1, "Dota", new ArrayList<>());
        QuestionName questionName2 = new QuestionName(2, "Lol", new ArrayList<>());
        QuestionName questionName3 = new QuestionName(3, "Sekiro", new ArrayList<>());

        QuestionImage questionImage = new QuestionImage(1, "backend/src/Images/dota2.jpg", questionName);
        QuestionImage questionImage2 = new QuestionImage(2, "backend/src/Images/lol.jpg", questionName2);
        QuestionImage questionImage3 = new QuestionImage(3, "backend/src/Images/sekiro.jpg", questionName3);

        questionNameRepositories.save(questionName);
        questionNameRepositories.save(questionName2);
        questionNameRepositories.save(questionName3);

        questionImageRepositories.save(questionImage);
        questionImageRepositories.save(questionImage2);
        questionImageRepositories.save(questionImage3);
    }
}
