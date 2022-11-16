package com.javaxpert.katas;

public class Drink  implements Product{
    double price = 2d;

    private String name;

    public Drink(String name) {
        this.name = name;
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
