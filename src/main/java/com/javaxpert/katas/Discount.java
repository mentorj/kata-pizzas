package com.javaxpert.katas;

import io.vavr.Function1;

public interface Discount {
    Function1<Double, Double> applyDiscount();
}
