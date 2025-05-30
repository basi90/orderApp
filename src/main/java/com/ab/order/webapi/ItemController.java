package com.ab.order.webapi;

import com.ab.order.service.DTOs.ItemInputDTO;
import com.ab.order.service.DTOs.ItemOutputDTO;
import com.ab.order.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemOutputDTO registerItem(@RequestBody ItemInputDTO input) {
        return itemService.createItem(input);
    }

    @PutMapping(path = "{id}", produces = "application/json")
    public Optional<ItemOutputDTO> updateItem(@PathVariable("id") Long id, @RequestBody ItemInputDTO input) {
        return itemService.updateItem(id, input);
    }
}
