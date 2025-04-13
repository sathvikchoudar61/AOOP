package com.ecommerce;
public class Main {
    public static void main(String[] args) {
        Product product = new Product("Laptop", 1200.00);
        Order order = new Order(1, product);
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        PaymentService paymentService = new PaymentService();
        productService.addProduct(product);
        orderService.createOrder(order);
        Payment payment = new Payment(1200.00);
        paymentService.processPayment(payment);
        System.out.println("Order processed successfully.");
    }
}
