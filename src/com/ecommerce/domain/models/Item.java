package com.ecommerce.domain.models;

public class Item {
    private final Product product;
    private final int quantity ;

    public Item(String productName, int quantity) {
        this.product = new Product(productName);
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Product " + product +" with quantity " + quantity;
    }
}
