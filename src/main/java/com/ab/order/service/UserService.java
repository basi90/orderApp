package com.ab.order.service;

import com.ab.order.infrastructure.UserRepository;
import com.ab.order.service.mappers.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    
}
