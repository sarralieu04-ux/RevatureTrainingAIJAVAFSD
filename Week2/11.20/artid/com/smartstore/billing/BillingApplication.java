package com.smartstore.billing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BillingApplicationTest {

    // Allowed difference between expected and actual double values.
    private static final double DELTA = 0.001;

    @Test
    void discountIsZeroWhenAmountIsBelow1000() {
        double actual = BillingApplication.calculateDiscount(800);

        assertEquals(0.0, actual, DELTA);
    }

    @Test
    void discountIs5PercentWhenAmountIsExactly1000() {
        double actual = BillingApplication.calculateDiscount(1000);

        assertEquals(50.0, actual, DELTA);
    }

    @Test
    void discountIs5PercentWhenAmountIs4999() {
        double actual = BillingApplication.calculateDiscount(4999);

        assertEquals(249.95, actual, DELTA);
    }

    @Test
    void discountIs10PercentWhenAmountIsExactly5000() {
        double actual = BillingApplication.calculateDiscount(5000);

        assertEquals(500.0, actual, DELTA);
    }

    @Test
    void discountIs10PercentWhenAmountIsAbove5000() {
        double actual = BillingApplication.calculateDiscount(7000);

        assertEquals(700.0, actual, DELTA);
    }
}
