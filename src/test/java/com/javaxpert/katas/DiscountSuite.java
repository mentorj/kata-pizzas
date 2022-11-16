package com.javaxpert.katas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiscountSuite {

    @Test
    void fixedZeroRateDiscountShouldNotChangePrice(){
        double start_price = 100d;
        FixedPriceCoupon coupon = new FixedPriceCoupon(0d);
        double result = coupon.applyDiscount().apply(start_price);
        double expected =100d;
        assertTrue(Math.abs(result-expected) < 0.01d);

    }

    @Test
    void tenEurosRebateRateDiscountShouldChangePrice(){
        double start_price = 100d;
        FixedPriceCoupon coupon = new FixedPriceCoupon(10f);
        double result = coupon.applyDiscount().apply(start_price);
        double expected =90f;
        assertTrue(Math.abs(result-expected) < 0.01d);

    }

    @Test
    void ratioZerodDiscountShouldNotChangePrice(){
        double start_price = 10d;
        RatioDiscount coupon = new RatioDiscount(0.0d);
        double result = coupon.applyDiscount().apply(start_price);
        double expected = 10d;
        System.out.println("Price is ="+ result);
        assertTrue(Math.abs(result-expected)<0.01d);
    }

    @Test
    void ratioTwentyPercentChangePrice(){
        double start_price = 100d;
        RatioDiscount coupon = new RatioDiscount(0.2d);
        double result = coupon.applyDiscount().apply(start_price);
        double expected = 80d;

        assertTrue(Math.abs(result-expected)<0.01d);
    }

    @Test
    void emptyOrderShouldHaveAPriceEqualToZero(){

    }

    @Test
    void orderWith3TimesTheSameProductsWithQuantityOneAndWithoutCouponShouldHaveAPriceOf3TimesUnitPrice(){
        Product p = new FakeProduct("Fake",10d);
        Discount discount = new FixedPriceCoupon(0d);
        Order order = new Order();
        order.addProduct(p,1,discount);
        order.addProduct(p,1,discount);
        order.addProduct(p,1,discount);
        System.out.println("Result tuple is ="+ order.computePrice());
        assertTrue(Math.abs(p.getPrice()*3 - order.computePrice()) <0.01d);

    }

}
