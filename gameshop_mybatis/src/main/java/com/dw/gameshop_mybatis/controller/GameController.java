package com.dw.gameshop_mybatis.controller;

import com.dw.gameshop_mybatis.dto.GameDTO;
import com.dw.gameshop_mybatis.enums.GameGenre;
import com.dw.gameshop_mybatis.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameController {
    @Autowired
    GameService gameService;

    @GetMapping("/all")
    public ResponseEntity<List<GameDTO>> getAllGames() {
        return new ResponseEntity<>(
                gameService.getAllGames(),
                HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<GameDTO> getGameById(@PathVariable long id) {
        return new ResponseEntity<>(
                gameService.getGameById(id),
                HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GameDTO>> getGamesByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return new ResponseEntity<>(
                gameService.getGamesByPage(page, size),
                HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<GameDTO>> searchGames(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) GameGenre genre,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return new ResponseEntity<>(
                gameService.searchGames(title,genre,page,size),
                HttpStatus.OK);
    }
}
