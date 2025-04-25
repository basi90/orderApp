package com.ab.order.webapi;

import com.ab.order.service.DTOs.UserInputDTO;
import com.ab.order.service.DTOs.UserOutputDTO;
import com.ab.order.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserControllerTest {

    private final UserService userService;

    public UserControllerTest(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserOutputDTO registerUser(@RequestBody UserInputDTO input) {
        return userService.createUser(input);
    }
}
