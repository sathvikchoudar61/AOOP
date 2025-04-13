package com.ecommerce;
public class OrderService {
    private ProductService productService = new ProductService();
    public void createOrder(Order order) {
        Product product = order.getProduct();
        System.out.println("Order created for:"+product.getName()+" with price: "+product.getPrice());
    }
}
