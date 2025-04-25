package com.ab.order.service.DTOs;

import com.ab.order.domain.User;
import com.ab.order.domain.UserRole;
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

    @Autowired
    private JacksonTester<UserOutputDTO> outputJson;

    @Test
    void serializeInputDto() throws IOException {
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

    @Test
    void deserializeOutputDto() throws IOException {
        UserOutputDTO dto = new UserOutputDTO(
                1,
                UserRole.CUSTOMER,
                "a@b.co",
                "a",
                "b",
                "c",
                "01"
        );

        String jsonString = """
                {
                "id": 1,
                "role": "CUSTOMER",
                "email": "a@b.co",
                "lastName": "a",
                "firstName": "b",
                "address": "c",
                "phoneNumber": "01"
                }
                """;

        assertThat(outputJson.write(dto)).isEqualToJson(jsonString);
    }
}
