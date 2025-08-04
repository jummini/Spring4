package com.dw.gameshop_mybatis.mapper;

import com.dw.gameshop_mybatis.model.Game;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GameMapper {
    List<Game> getAllGames();
}
