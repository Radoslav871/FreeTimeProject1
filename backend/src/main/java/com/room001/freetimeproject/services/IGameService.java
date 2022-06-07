package com.room001.freetimeproject.services;

import com.room001.freetimeproject.Dtos.game.GameResponse;

public interface IGameService {
    GameResponse StartGame();
    void AddGames();
}
