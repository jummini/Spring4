package com.dw.gameshop_mybatis.controller;

import com.dw.gameshop_mybatis.dto.PurchaseDTO;
import com.dw.gameshop_mybatis.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;

    @PostMapping("/save/list")
    public ResponseEntity<List<PurchaseDTO>> savePurchaseList(
            @RequestBody List<PurchaseDTO> purchaseDTOList) {
        return new ResponseEntity<>(
                purchaseService.savePurchaseList(purchaseDTOList),
                HttpStatus.CREATED);
    }
}
