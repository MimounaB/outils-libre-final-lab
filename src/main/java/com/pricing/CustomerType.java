package com.pricing;

public enum CustomerType {
    REGULAR(0.0),
    VIP(0.05);
    
    private final double additionalDiscount;
    
    CustomerType(double additionalDiscount) {
        this.additionalDiscount = additionalDiscount;
    }
    
    public double getAdditionalDiscount() {
        return additionalDiscount;
    }
}