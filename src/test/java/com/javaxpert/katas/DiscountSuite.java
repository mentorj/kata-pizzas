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
    void orderWith3TimesTheSameProductsWithQuantityOneAndWithoutCouponShouldHaveAPriceOf3TimesUnitPrice(){
        Product p = new FakeProduct("Fake",10d);
        Discount discount = new FixedPriceCoupon(0d);
        Order order = new Order();
        order.addProduct(p,1,discount);
        order.addProduct(p,1,discount);
        order.addProduct(p,1,discount);
        System.out.println("Result tuple is ="+ order.getPrice());
        assertTrue(Math.abs(p.getPrice()*3 - order.getPrice()) <0.01d);

    }

    @Test
    void simpleOrderWith2ProductsWithoutRebate(){
        Product p1 = new Drink("Coke");
        Product p2 = new Drink("Perrier");
        Order order = new Order();
        order.addProduct(p1,2,new FixedPriceCoupon(0d));
        order.addProduct(p2,2,new FixedPriceCoupon(0d));
        assertTrue(Math.abs(order.getPrice() - 8d) < 0.01d);
    }

    @Test
    void simpleOrderWithFixedRebates(){
        Product p1 = new Wine(100d,"Mumm");
        Product p2 = new Wine(200d,"Taitinger Cuvee Millenaire");

        Order order = new Order();
        order.addProduct(p1,1,new FixedPriceCoupon(20d));
        order.addProduct(p2,1,new RatioDiscount(0.2d));
        assertTrue(Math.abs(order.getPrice() -240d)<1d);
    }


    @Test
    void orderWithAStandardCalzone(){
        Order order=new Order();
        order.addProduct(new Calzone(new StandardPizza("Regina")),1,new FixedPriceCoupon(0d));
        assertTrue(Math.abs(order.getPrice() - 8d)<0.01d);
    }

    @Test
    void orderWithMediumStadardCalzone(){
        Order order = new Order();
        order.addProduct(new MediumPizza(new Calzone(new StandardPizza("regina"))), 1, new FixedPriceCoupon(0d));
        assertTrue(Math.abs(order.getPrice()-8.80d)<0.001d);
    }

    @Test
    void discountedSimpleOrder(){
        Order order = new Order();
        order.addProduct(new StandardPizza("reine"),1,new FixedPriceCoupon(0d));
        OrderScopeCoupon coupon = new OrderScopeCoupon(order,0.1d);
        assertTrue(Math.abs(coupon.getPrice() -5.40d)<0.001d);

    }

}
