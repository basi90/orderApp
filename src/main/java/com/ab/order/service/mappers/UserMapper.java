package com.ab.order.service.mappers;

import com.ab.order.domain.User;
import com.ab.order.service.DTOs.UserInputDTO;
import com.ab.order.service.DTOs.UserOutputDTO;
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

    public UserOutputDTO convertUserInOutputDto(User user) {
        return new UserOutputDTO(
                user.getId(),
                user.getRole(),
                user.getEmail(),
                user.getLastName(),
                user.getFirstName(),
                user.getAddress(),
                user.getPhoneNumber()
        );
    }
}
