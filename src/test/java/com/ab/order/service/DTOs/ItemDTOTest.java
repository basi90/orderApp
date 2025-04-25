package com.ab.order.service.DTOs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class ItemDTOTest {

    @Autowired
    private JacksonTester<ItemInputDTO> inputJson;

    @Autowired
    private JacksonTester<ItemOutputDTO> outputJson;

    @Test
    void serializeInputDto() throws IOException {
        ItemInputDTO dto = new ItemInputDTO(
                "a",
                "b",
                9.99,
                1
        );

        String jsonString = """
                {
                "name": "a",
                "description": "b",
                "price": 9.99,
                "amountInStock": 1
                }
                """;

        assertThat(inputJson.write(dto)).isEqualToJson(jsonString);
    }

    @Test
    void serializeOutputDto() throws IOException {
        ItemOutputDTO dto = new ItemOutputDTO(
                1,
                "a",
                "b",
                9.99,
                1
        );

        String jsonString = """
                {
                "id": 1,
                "name": "a",
                "description": "b",
                "price": 9.99,
                "amountInStock": 1
                }
                """;
        
        assertThat(outputJson.write(dto)).isEqualToJson(jsonString);
    }
}
