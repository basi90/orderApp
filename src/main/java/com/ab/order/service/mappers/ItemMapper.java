package com.ab.order.service.mappers;

import com.ab.order.domain.Item;
import com.ab.order.service.DTOs.ItemInputDTO;
import com.ab.order.service.DTOs.ItemOutputDTO;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public Item convertInputDTOtoItem(ItemInputDTO dto) {
        return new Item(
                dto.getName(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getStockAmount()
        );
    }

    public ItemOutputDTO convertItemToOutputDTO(Item item) {
        return new ItemOutputDTO(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getPrice(),
                item.getStockAmount()
        );
    }
}
