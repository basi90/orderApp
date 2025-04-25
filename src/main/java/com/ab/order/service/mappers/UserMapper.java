package com.ab.order.service.mappers;

import com.ab.order.domain.User;
import com.ab.order.service.DTOs.UserInputDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User convertInputDtoInUser(UserInputDTO dto) {
        return new User(
                dto.getEmail(),
                dto.getPassword(),
                dto.getLastName(),
                dto.getFirstName(),
                dto.getAddress(),
                dto.getPhoneNumber()
        );
    }
}
