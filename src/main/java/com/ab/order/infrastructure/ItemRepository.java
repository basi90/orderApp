package com.ab.order.infrastructure;

import com.ab.order.domain.Item;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ItemRepository {
    private HashMap<Long, Item> items;

    public ItemRepository() {
        items = new HashMap<>();
    }

    public void saveToDb(Item item) {
        items.put(item.getId(), item);
    }
}
