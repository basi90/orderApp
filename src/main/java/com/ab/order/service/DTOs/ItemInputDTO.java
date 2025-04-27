package com.ab.order.service.DTOs;

public class ItemInputDTO {
    private String name;
    private String description;
    private double price;
    private long stockAmount;

    public ItemInputDTO(String name, String description, double price, long stockAmount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockAmount = stockAmount;
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
}
