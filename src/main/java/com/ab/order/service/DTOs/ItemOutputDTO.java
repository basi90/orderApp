package com.ab.order.service.DTOs;

import java.util.Objects;

public class ItemOutputDTO {
    private long id;
    private String name;
    private String description;
    private double price;
    private long amountInStock;

    public ItemOutputDTO(long id, String name, String description, double price, long amountInStock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountInStock = amountInStock;
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

    public long getAmountInStock() {
        return amountInStock;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemOutputDTO that = (ItemOutputDTO) o;
        return id == that.id && Double.compare(price, that.price) == 0 && amountInStock == that.amountInStock && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, amountInStock);
    }
}
