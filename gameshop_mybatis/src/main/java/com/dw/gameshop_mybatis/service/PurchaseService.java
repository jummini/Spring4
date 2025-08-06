package com.dw.gameshop_mybatis.service;

import com.dw.gameshop_mybatis.dto.PurchaseDTO;
import com.dw.gameshop_mybatis.mapper.GameMapper;
import com.dw.gameshop_mybatis.mapper.PurchaseMapper;
import com.dw.gameshop_mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PurchaseService {
    @Autowired
    PurchaseMapper purchaseMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    GameMapper gameMapper;

    // @Transactional 어노테이션을 추가하여, 메서드내의 모든 DB 작업이 하나의
    // 단위(=트랜잭션)로 묶이도록 해야 함. (서비스레이어에 반드시 사용!!)
    // 이렇게 하면 중간에 오류가 발생 시 모든 작업이 롤백(취소)되어 데이터 일관성을
    // 보장할 수 있음.
    @Transactional
    public List<PurchaseDTO> savePurchaseList(
                List<PurchaseDTO> purchaseDTOList) {

    }
}
