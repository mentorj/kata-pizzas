package com.javaxpert.katas;

public class Wine implements Product {
    private double price;
    private String name;

    public Wine(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
