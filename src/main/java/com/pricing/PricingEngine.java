package com.pricing;

import java.util.List;

public class PricingEngine {
    
    // ========== الطريقة القديمة (للتوافق) ==========
    public double calc(List<Double> p, List<Integer> q, String ct, String dc) {
        double s = 0;
        for(int i=0; i<p.size(); i++) {
            s = s + (p.get(i) * q.get(i));
        }
        
        double d = 0;
        if(dc != null) {
            if(dc.equals("SAVE10")) d = s * 0.10;
            else if(dc.equals("SAVE20")) d = s * 0.20;
            else if(dc.equals("SAVE30")) d = s * 0.30;
        }
        
        if(ct != null && ct.equals("VIP")) {
            d = d + (s * 0.05);
        }
        
        double t = s * 0.15;
        double f = s - d + t;
        
        System.out.println("Subtotal: " + s);
        System.out.println("Discount: " + d);
        System.out.println("Tax: " + t);
        
        return f;
    }
    
    // ========== الطريقة المحسنة (Refactored) ==========
    public double calculateFinalPrice(List<Double> prices, List<Integer> quantities, 
                                       CustomerType customerType, DiscountCode discountCode) {
        double subtotal = calculateSubtotal(prices, quantities);
        double discount = calculateDiscount(subtotal, customerType, discountCode);
        double tax = calculateTax(subtotal);
        
        printDetails(subtotal, discount, tax);
        
        return subtotal - discount + tax;
    }
    
    private double calculateSubtotal(List<Double> prices, List<Integer> quantities) {
        double subtotal = 0;
        for (int i = 0; i < prices.size(); i++) {
            subtotal += prices.get(i) * quantities.get(i);
        }
        return subtotal;
    }
    
    private double calculateDiscount(double subtotal, CustomerType customerType, DiscountCode discountCode) {
        double discount = 0;
        
        if (discountCode != null && discountCode != DiscountCode.NONE) {
            discount = subtotal * discountCode.getRate();
        }
        
        if (customerType == CustomerType.VIP) {
            discount += subtotal * customerType.getAdditionalDiscount();
        }
        
        return discount;
    }
    
    private double calculateTax(double subtotal) {
        return subtotal * 0.15;
    }
    
    private void printDetails(double subtotal, double discount, double tax) {
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Discount: " + discount);
        System.out.println("Tax: " + tax);
    }
}
