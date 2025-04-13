package com.ecommerce;
import java.util.ArrayList;
import java.util.List;
public class ProductService {
    private List<Product> productList = new ArrayList<>();
    public void addProduct(Product product) {
        productList.add(product);
        System.out.println("Product added: " + product.getName());
    }
    public Product getProduct(String productName) {
        for (Product product : productList) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }
}
