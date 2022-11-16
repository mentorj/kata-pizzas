package com.javaxpert.katas;

public class MediumPizza extends Pizza{

    private Pizza wrapped;

    public MediumPizza(Pizza wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public double getPrice() {
        return 1.1d* wrapped.getPrice();
    }

    @Override
    public String getName() {
        return "Medium size " + wrapped.getName();
    }
}
