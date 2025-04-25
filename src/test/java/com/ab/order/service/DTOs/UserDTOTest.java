package com.ab.order.service.DTOs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class UserDTOTest {

    @Autowired
    private JacksonTester<UserInputDTO> inputJson;

    @Test
    void serializeInputDtoInUser() throws IOException {
        UserInputDTO dto = new UserInputDTO(
                "a@b.co",
                "pass",
                "a",
                "b",
                "c",
                "01"
                );

        String jsonString = """
                {
                "email": "a@b.co",
                "password": "pass",
                "lastName": "a",
                "firstName": "b",
                "address": "c",
                "phoneNumber": "01"
                }
                """;

        assertThat(inputJson.write(dto)).isEqualToJson(jsonString);
    }
}
