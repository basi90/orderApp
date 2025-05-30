package com.ab.order.service;

import com.ab.order.domain.Item;
import com.ab.order.infrastructure.ItemRepository;
import com.ab.order.service.DTOs.ItemInputDTO;
import com.ab.order.service.DTOs.ItemOutputDTO;
import com.ab.order.service.mappers.ItemMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        itemRepository.save(newItem);
        return itemMapper.convertItemToOutputDTO(newItem);
    }

    public Optional<ItemOutputDTO> updateItem(Long id, ItemInputDTO dto) {
        Optional<Item> itemOptional = itemRepository.findById(id);

        if (itemOptional.isPresent()) {
            Item item = itemOptional.get();
            item.setName(dto.getName());
            item.setDescription(dto.getDescription());
            item.setPrice(dto.getPrice());
            item.setStockAmount(dto.getStockAmount());

            itemRepository.save(item);

            return Optional.of(itemMapper.convertItemToOutputDTO(item));
        }
        return Optional.empty();
    }
}
