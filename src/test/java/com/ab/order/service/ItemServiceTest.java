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

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
                1L
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
        verify(itemRepository).save(item);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void givenValidId_whenUpdateItem_thenReturnOutputDTO() {
        long itemId = 1;
        ItemInputDTO input = new ItemInputDTO(
                "b",
                "c",
                19.99,
                4L
        );

        Item item = new Item(
                "a",
                "b",
                9.99,
                3L
        );

        when(itemRepository.findById(itemId)).thenReturn(Optional.of(item));

        ItemOutputDTO expected = new ItemOutputDTO(
                1,
                "b",
                "c",
                19.99,
                4
        );

        when(itemMapper.convertItemToOutputDTO(item)).thenReturn(expected);

        Optional<ItemOutputDTO> result = itemService.updateItem(itemId, input);

        assertTrue(result.isPresent());
        assertEquals(expected, result.get());

        assertEquals("b", result.get().getName());
        assertEquals("c", result.get().getDescription());
        assertEquals(19.99, result.get().getPrice());
        assertEquals(4, result.get().getStockAmount());

        assertEquals("b", item.getName());
        assertEquals("c", item.getDescription());
        assertEquals(19.99, item.getPrice());
        assertEquals(4, item.getStockAmount());

        verify(itemMapper).convertItemToOutputDTO(item);
    }
}
