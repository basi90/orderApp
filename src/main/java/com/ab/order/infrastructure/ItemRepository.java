package com.ab.order.infrastructure;

import com.ab.order.domain.Item;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

@Repository
public class ItemRepository {
    private HashMap<Long, Item> items;

    public ItemRepository() {
        items = new HashMap<>();
    }

    public void saveToDb(Item item) {
        items.put(item.getId(), item);
    }

    public Optional<Item> findById(long id) {
        return Optional.ofNullable(items.get(id));
    }
}
