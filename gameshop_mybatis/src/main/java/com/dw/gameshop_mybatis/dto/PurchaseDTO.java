package com.dw.gameshop_mybatis.dto;

import java.time.LocalDateTime;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PurchaseDTO {
    private long id;
    private GameDTO game;
    private UserDTO user;
    private LocalDateTime purchaseTime;
}
