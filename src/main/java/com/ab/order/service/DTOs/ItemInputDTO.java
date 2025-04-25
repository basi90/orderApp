package com.ab.order.service.DTOs;

public class ItemInputDTO {
    private String name;
    private String description;
    private double price;
    private long amountInStock;

    public ItemInputDTO(String name, String description, double price, long amountInStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amountInStock = amountInStock;
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
}
