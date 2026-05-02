package com.pricing;

import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PricingEngineTest {
    
    private PricingEngine engine;
    
    @BeforeEach
    void setUp() {
        engine = new PricingEngine();
    }
    
    // ========== اختبارات الطريقة القديمة ==========
    @Test
    void testRegularCustomerNoDiscount() {
        List<Double> prices = Arrays.asList(100.0);
        List<Integer> quantities = Arrays.asList(1);
        
        double result = engine.calc(prices, quantities, "REGULAR", null);
        assertEquals(115.0, result, 0.01);
    }
    
    @Test
    void testVipCustomerNoDiscountCode() {
        List<Double> prices = Arrays.asList(100.0);
        List<Integer> quantities = Arrays.asList(1);
        
        double result = engine.calc(prices, quantities, "VIP", null);
        assertEquals(109.25, result, 0.01);
    }
    
    // ========== اختبارات الطريقة المحسنة ==========
    @Test
    void testRefactoredRegularCustomerNoDiscount() {
        List<Double> prices = Arrays.asList(100.0);
        List<Integer> quantities = Arrays.asList(1);
        
        double result = engine.calculateFinalPrice(prices, quantities, 
                                                   CustomerType.REGULAR, DiscountCode.NONE);
        assertEquals(115.0, result, 0.01);
    }
    
    @Test
    void testRefactoredVipCustomerNoDiscountCode() {
        List<Double> prices = Arrays.asList(100.0);
        List<Integer> quantities = Arrays.asList(1);
        
        double result = engine.calculateFinalPrice(prices, quantities, 
                                                   CustomerType.VIP, DiscountCode.NONE);
        assertEquals(109.25, result, 0.01);
    }
    
    @Test
    void testRefactoredSave10Discount() {
        List<Double> prices = Arrays.asList(100.0);
        List<Integer> quantities = Arrays.asList(1);
        
        double result = engine.calculateFinalPrice(prices, quantities, 
                                                   CustomerType.REGULAR, DiscountCode.SAVE10);
        assertEquals(103.5, result, 0.01);
    }
}