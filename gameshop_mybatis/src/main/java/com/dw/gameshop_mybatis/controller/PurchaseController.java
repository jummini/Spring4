package com.dw.gameshop_mybatis.controller;

import com.dw.gameshop_mybatis.dto.PurchaseDTO;
import com.dw.gameshop_mybatis.model.User;
import com.dw.gameshop_mybatis.service.PurchaseService;
import com.dw.gameshop_mybatis.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;
    @Autowired
    UserService userService;

    @PostMapping("/save/list")
    public ResponseEntity<List<PurchaseDTO>> savePurchaseList(
            @RequestBody List<PurchaseDTO> purchaseDTOList) {
        return new ResponseEntity<>(
                purchaseService.savePurchaseList(purchaseDTOList),
                HttpStatus.CREATED);
    }

    @GetMapping("/current-user")
    public ResponseEntity<List<PurchaseDTO>> getPurchaseListByCurrentUser(
                                    HttpServletRequest request) {
        User currentUser = userService.getCurrentUser(request);
        return new ResponseEntity<>(
                purchaseService.getPurchaseListByCurrentUser(currentUser),
                HttpStatus.OK);
    }

    // [관리자권한] 모든 구매내역을 조회하므로 현재 세션이 관리자인지 확인 필요!
    @GetMapping("/all")
    public ResponseEntity<List<PurchaseDTO>> getAllPurchases(
                                    HttpServletRequest request) {
        User currentUser = userService.getCurrentUser(request);
        return new ResponseEntity<>(
                purchaseService.getAllPurchases(currentUser),
                HttpStatus.OK);
    }
    // [관리자권한] 유저 구매내역을 조회하므로 현재 세션이 관리자인지 확인 필요!
    @GetMapping("/user/{userName}")
    public ResponseEntity<List<PurchaseDTO>> getPurchaseListByUserName(
            @PathVariable String userName, HttpServletRequest request) {
        User currentUser = userService.getCurrentUser(request);
        return new ResponseEntity<>(
                purchaseService.getPurchaseListByUserName(currentUser),
                HttpStatus.OK);
    }
}
