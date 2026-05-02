package com.pricing;

public enum DiscountCode {
    NONE(0.0),
    SAVE10(0.10),
    SAVE20(0.20),
    SAVE30(0.30);
    
    private final double rate;
    
    DiscountCode(double rate) {
        this.rate = rate;
    }
    
    public double getRate() {
        return rate;
    }
}