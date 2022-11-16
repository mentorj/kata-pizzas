package com.javaxpert.katas;

import io.vavr.Function1;
import io.vavr.Function2;

public class FixedPriceCoupon implements Discount{
    private double fixedRate;
    public FixedPriceCoupon(double rate) {
        fixedRate=rate;
    }

    @Override
    public Function1<Double, Double> applyDiscount() {
        Function2<Double,Double,Double> f = (a,b) -> b - a;
        return f.apply(fixedRate);
    }
}
