package com.javaxpert.katas;

public class OrderScopeCoupon extends Order{
    private Order wrappedOrder;
    private double discountRatio;

    public OrderScopeCoupon(Order wrappedOrder,double discountRatio) {
        this.wrappedOrder = wrappedOrder;
        this.discountRatio=discountRatio;
    }


    @Override
    public double getPrice() {
        return wrappedOrder.getPrice() - wrappedOrder.getPrice()*discountRatio;
    }
}
