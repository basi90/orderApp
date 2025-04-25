package com.ab.order.service;

import com.ab.order.domain.User;
import com.ab.order.infrastructure.UserRepository;
import com.ab.order.service.DTOs.UserInputDTO;
import com.ab.order.service.DTOs.UserOutputDTO;
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

    public UserOutputDTO createUser(UserInputDTO dto) {
        User newUser = userMapper.convertInputDtoInUser(dto);
        userRepository.saveToDb(newUser);
        return userMapper.convertUserInOutputDto(newUser);
    }
}
