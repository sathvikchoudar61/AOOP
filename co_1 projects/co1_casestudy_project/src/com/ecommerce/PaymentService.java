package com.ecommerce;

public class PaymentService {
    // Process payment
    public void processPayment(Payment payment) {
        System.out.println("Payment of " + payment.getAmount() + " processed successfully.");
    }
}
