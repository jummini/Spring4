package com.dw.gameshop_mybatis.service;

import com.dw.gameshop_mybatis.mapper.GameMapper;
import com.dw.gameshop_mybatis.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    GameMapper gameMapper;

    public List<Game> getAllGames() {
        return gameMapper.getAllGames();
    }

    public Game getGameById(long id) {
        return gameMapper.getGameById(id);
    }
}
