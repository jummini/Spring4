package com.dw.gameshop_mybatis.service;

import com.dw.gameshop_mybatis.mapper.UserMapper;
import com.dw.gameshop_mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    UserMapper userMapper;

    public boolean validateUser(String username,
                                String password) {
        User user = userMapper.getUserByUserName(username);
        return user != null &&
                passwordEncoder.matches(password, user.getPassword());
    }
}
