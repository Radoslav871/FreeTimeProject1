package com.room001.freetimeproject.controllers;

import com.room001.freetimeproject.Dtos.game.GameResponse;
import com.room001.freetimeproject.Util.JwtUtil;
import com.room001.freetimeproject.models.UserModel;
import com.room001.freetimeproject.services.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    private IGameService iGameService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    public GameController(IGameService iGameService) {
        this.iGameService = iGameService;
    }

    //================Game page=================
    @GetMapping("/game")
    public ResponseEntity LoadNewGame(@RequestHeader (name="Authorization") String token){

        // after calling this endpoint you will get 3 pictures with names of the game
        // now it is frontend problem to solve this :D
        // if not logic will change >(
        token = token.substring(7);
        String user = jwtTokenUtil.extractUsername(token);

        GameResponse gameResponse = iGameService.StartGame(user);

        return ResponseEntity.ok(gameResponse);
    }
    //================for adding games...=================
    @GetMapping("/gameAdd")
    public ResponseEntity ForAddingGames(){

        iGameService.AddGames();

        return new ResponseEntity(HttpStatus.OK);
    }
}
