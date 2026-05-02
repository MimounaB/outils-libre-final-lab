package com.pricing;

import java.util.*;

public class PricingEngine {
    
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
}
