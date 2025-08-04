package com.dw.gameshop_mybatis.controller;

import com.dw.gameshop_mybatis.model.Game;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameController {
    @GetMapping("/all")
    public List<Game> getAllGames() {
        return 
    }
}
