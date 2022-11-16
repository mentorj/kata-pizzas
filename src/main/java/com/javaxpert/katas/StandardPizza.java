package com.javaxpert.katas;

public class StandardPizza extends Pizza{
    public StandardPizza(String name) {
        this.name=name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return 6d;
    }
}
