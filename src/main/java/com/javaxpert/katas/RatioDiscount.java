package com.javaxpert.katas;

import io.vavr.Function1;
import io.vavr.Function2;

public class RatioDiscount implements Discount{
    private double ratio;

    /**
     * compute a discount with percentage
     *
     * @param ratio,
     */
    public RatioDiscount(double ratio) {
        this.ratio=ratio;
    }

    @Override
    public Function1<Double, Double> applyDiscount() {
        Function2<Double,Double,Double> f = (a,b) -> b- (a*b);
        return f.apply(ratio);
    }
}
