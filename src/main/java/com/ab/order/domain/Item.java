package com.ab.order.domain;

import java.util.Objects;

public class Item {
    private long id;
    private String name;
    private String description;
    private double price;
    private long stockAmount;

    private static long nextId = 1;

    public Item(String name, String description, double price, long stockAmount) {
        this.id = nextId++;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockAmount = stockAmount;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public long getStockAmount() {
        return stockAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
