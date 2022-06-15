package com.room001.freetimeproject.services;

import com.room001.freetimeproject.Dtos.game.GameResponse;
import com.room001.freetimeproject.models.QuestionImage;
import com.room001.freetimeproject.models.QuestionName;
import com.room001.freetimeproject.models.UserModel;
import com.room001.freetimeproject.repositories.QuestionImageRepositories;
import com.room001.freetimeproject.repositories.QuestionNameRepositories;
import com.room001.freetimeproject.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GameService implements IGameService {

    private QuestionImageRepositories questionImageRepositories;
    private QuestionNameRepositories questionNameRepositories;
    private UserRepositories userRepositories;

    // you have question name class that stores name of game
    // and question image stores path to the picture and id of question name

    @Autowired
    public GameService(QuestionImageRepositories questionImageRepositories, QuestionNameRepositories questionNameRepositories, UserRepositories userRepositories) {
        this.questionImageRepositories = questionImageRepositories;
        this.questionNameRepositories = questionNameRepositories;
        this.userRepositories = userRepositories;
    }

    @Override
    public GameResponse StartGame(String username) {

        // also add check that you will not get same pic in 1 game and then in 2 or 3
        UserModel user = userRepositories.findByUsername(username);

        CheckBeforeGame(user);

        GameResponse gameResponse = GenerateRandomPictures();

        return gameResponse;
    }

    private boolean CheckBeforeGame(UserModel user) {

        LocalDateTime userLastVote = user.getLastVote();
        LocalDateTime timeNow = LocalDateTime.now();

        if (userLastVote.getDayOfYear() >= timeNow.getDayOfYear()) {
            // throwing exception might be a problem but this is future Rado problem :)
            throw new RuntimeException("Can t vote more than once per day");
        }

        user.setLastVote(timeNow);
        userRepositories.save(user);
        return true;
    }

    private GameResponse GenerateRandomPictures() {
        long max = questionImageRepositories.count();

        Random random = new Random();

        List<QuestionImage> questionImages = new ArrayList<>();
        GameResponse gameResponse = new GameResponse(questionImages);

        ArrayList<Long> randomNumbers = new ArrayList<Long>(2);

        while (randomNumbers.size() < 2) {

            long temp = random.nextInt(1, (int) max + 1);
            if (!randomNumbers.contains(temp)) {
                randomNumbers.add(temp);
            }
        }

        for (int i = 0; i < 2; i++) {
            questionImages.add(questionImageRepositories.findAllById(randomNumbers.get(i)));
        }

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
