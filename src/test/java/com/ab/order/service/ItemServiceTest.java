package com.ab.order.service;

import com.ab.order.domain.Item;
import com.ab.order.infrastructure.ItemRepository;
import com.ab.order.service.DTOs.ItemInputDTO;
import com.ab.order.service.DTOs.ItemOutputDTO;
import com.ab.order.service.mappers.ItemMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private ItemMapper itemMapper;

    @InjectMocks
    private ItemService itemService;

    @Test
    void whenCreateItem_thenReturnOutputDTO() {
        ItemInputDTO input = new ItemInputDTO(
                "a",
                "b",
                9.99,
                1
        );

        Item item = new Item(
                "a",
                "b",
                9.99,
                1
        );

        ItemOutputDTO expected = new ItemOutputDTO(
                1,
                "a",
                "b",
                9.99,
                1
        );

        when(itemMapper.convertInputDTOtoItem(input)).thenReturn(item);
        when(itemMapper.convertItemToOutputDTO(item)).thenReturn(expected);

        ItemOutputDTO actual = itemService.createItem(input);

        verify(itemMapper).convertInputDTOtoItem(input);
        verify(itemMapper).convertItemToOutputDTO(item);
        verify(itemRepository).saveToDb(item);

        assertThat(actual).isEqualTo(expected);
    }
}
