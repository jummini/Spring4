package com.dw.gameshop_mybatis.mapper;

import com.dw.gameshop_mybatis.model.Purchase;
import com.dw.gameshop_mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PurchaseMapper {
    void savePurchase(@Param("purchase") Purchase purchase);
    void savePurchaseList(
            @Param("purchaseList") List<Purchase> purchaseList);
    List<Purchase> getAllPurchases();
    List<Purchase> getPurchaseListByUserName(
            @Param("userName") String userName);
    int countPurchaseByUserNameAndGameId(@Param("userName") String userName,
                                         @Param("gameId") Long gameId);
}
