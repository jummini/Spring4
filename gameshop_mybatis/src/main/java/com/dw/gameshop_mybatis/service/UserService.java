package com.dw.gameshop_mybatis.service;

import com.dw.gameshop_mybatis.dto.UserDTO;
import com.dw.gameshop_mybatis.exception.InvalidRequestException;
import com.dw.gameshop_mybatis.exception.ResourceNotFoundException;
import com.dw.gameshop_mybatis.exception.UnauthorizedUserException;
import com.dw.gameshop_mybatis.mapper.UserMapper;
import com.dw.gameshop_mybatis.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    UserMapper userMapper;

    public UserDTO registerUser(UserDTO userDTO) {
        User user = userMapper.getUserByUserName(userDTO.getUserName());
        if (user != null) {
            throw new InvalidRequestException("Username already exists");
        }
        String encode = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encode);
        userMapper.registerUser(userDTO);
        userDTO.setPassword(null); // 응답 전 비밀번호 필드를 null로 변경(중요!!)
        return userDTO;
    }

    public boolean validateUser(String username,
                                String password) {
        User user = userMapper.getUserByUserName(username);
        return user != null &&
                passwordEncoder.matches(password, user.getPassword());
    }

    public User getCurrentUser(HttpServletRequest request) {
        // getSession()의 매개변수를 true로 하면 세션이 없을 경우,
        // 세션을 새로 만들어서 리턴하라는 의미. false는 세션없으면 null 리턴.
        HttpSession session = request.getSession(false);
        if (session == null) {
            throw new UnauthorizedUserException("No session exist");
        }
        String userName = (String) session.getAttribute("username");
        User user = userMapper.getUserByUserName(userName);
        if (user == null) {
            throw new ResourceNotFoundException("No username");
        }
        return user;
    }
}
