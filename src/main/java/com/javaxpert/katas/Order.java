package com.javaxpert.katas;

import io.vavr.Tuple;
import io.vavr.Tuple3;
import io.vavr.collection.List;

import java.util.ArrayList;


/**
 *An order is a list of Tuples containing:
 *  - A product
 *  - A quantity
 *  - A discount
 *  By default no discount means a 0 euros rebate discount
 * @author deadbrain
 */
public class Order implements Billable{

    private java.util.List<Tuple3<Product,Integer, Discount>> orderList;

    public Order(){
        orderList= new ArrayList<>(10);
    }

    /**
     * compute the price for the whole order
     * using standard price per unit , then discounted with Coupon and multiplied by the quantity in  the order
     * @return
     */
    public double getPrice(){

        System.out.println("computePrice ,with an order of size ="+ orderList.size());
        List<Tuple3<Product,Integer,Discount>> immutableList = List.ofAll(orderList);
        // reduce requires to handle Tuples and return a temporary Tuple...
        Tuple3<Product,Integer,Discount> resultTuple= immutableList.reduce((product1Tuple, product2Tuple) ->
        {
            System.out.println("reducing 2 Tuples");
            double initial_price1 =product1Tuple._1.getPrice();
            double initial_price2 = product2Tuple._1.getPrice();
            double unit_price_with_coupon1 = product1Tuple._3.applyDiscount().apply(initial_price1);
            double unit_price_with_coupon2 = product2Tuple._3.applyDiscount().apply(initial_price2);
            double subTotal1 = product1Tuple._2*unit_price_with_coupon1;
            double subTotal2 = product2Tuple._2*unit_price_with_coupon2;
            double sumTotalTempo =   subTotal2+subTotal1;
            return Tuple.of(new FakeProduct("Fake",sumTotalTempo),1,new FixedPriceCoupon(0d));
        }

        // result is simply the price for the last Tuple...
        );
        System.out.println("computePrice  for order:"+ resultTuple._1.getPrice());
        return  resultTuple._1.getPrice();
    }

    public void addProduct(Product product,int howMany,Discount discount){
        orderList.add(Tuple.of(product,howMany,discount));
    }
}
