package com.dw.gameshop_mybatis.model;

import com.dw.gameshop_mybatis.enums.GameGenre;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Game {
    private long id;
    private String title;
    private GameGenre genre;
    private int price;
    private String image_url;
    private String text;
}
