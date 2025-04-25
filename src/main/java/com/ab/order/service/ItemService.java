package com.ab.order.service;

import com.ab.order.domain.Item;
import com.ab.order.infrastructure.ItemRepository;
import com.ab.order.service.DTOs.ItemInputDTO;
import com.ab.order.service.DTOs.ItemOutputDTO;
import com.ab.order.service.mappers.ItemMapper;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public ItemOutputDTO createItem(ItemInputDTO dto) {
        Item newItem = itemMapper.convertInputDTOtoItem(dto);
        itemRepository.saveToDb(newItem);
        return itemMapper.convertItemToOutputDTO(newItem);
    }
}
