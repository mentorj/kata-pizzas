package com.javaxpert.katas;

public class Calzone extends Pizza{
    private Pizza wrapped;

    public Calzone(Pizza pizza){
        wrapped=pizza;
    }
    @Override
    public double getPrice() {
        return 2d+ wrapped.getPrice();
    }

    @Override
    public String getName() {
        return "Calzone like " + wrapped.getName();
    }
}
