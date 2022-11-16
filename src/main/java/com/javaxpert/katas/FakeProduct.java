package com.javaxpert.katas;

public class FakeProduct implements Product{
    private String name;
    private double price;
    public FakeProduct(String name,double price) {
        this.name=name;
        this.price=price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getName() {
        return name;
    }
}
