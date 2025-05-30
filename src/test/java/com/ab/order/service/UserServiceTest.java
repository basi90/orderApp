package com.ab.order.service;

import com.ab.order.domain.User;
import com.ab.order.domain.UserRole;
import com.ab.order.infrastructure.UserRepository;
import com.ab.order.service.DTOs.UserInputDTO;
import com.ab.order.service.DTOs.UserOutputDTO;
import com.ab.order.service.mappers.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @Test
    void whenCreateUser_thenReturnUserOutputDTO() {
        UserInputDTO input = new UserInputDTO(
                "a@b.co",
                "pass",
                "a",
                "b",
                "c",
                "01"
        );

        User user = new User(
                "a@b.co",
                "pass",
                "a",
                "b",
                "c",
                "01"
        );

        UserOutputDTO expected = new UserOutputDTO(
                1,
                UserRole.CUSTOMER,
                "a@b.co",
                "a",
                "b",
                "c",
                "01"
        );

        when(userMapper.convertInputDtoInUser(input)).thenReturn(user);
        when(userMapper.convertUserInOutputDto(user)).thenReturn(expected);

        UserOutputDTO actual = userService.createUser(input);

        verify(userMapper).convertInputDtoInUser(input);
        verify(userMapper).convertUserInOutputDto(user);
        verify(userRepository).save(user);

        assertThat(actual).isEqualTo(expected);
    }
}
