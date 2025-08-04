package com.dw.gameshop_mybatis.controller;

import com.dw.gameshop_mybatis.dto.GameDTO;
import com.dw.gameshop_mybatis.model.Game;
import com.dw.gameshop_mybatis.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameController {
    @Autowired
    GameService gameService;

    @GetMapping("/all")
    public List<GameDTO> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/id/{id}")
    public GameDTO getGameById(@PathVariable long id) {
        return gameService.getGameById(id);
    }
}
