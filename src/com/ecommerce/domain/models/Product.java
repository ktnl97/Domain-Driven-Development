package com.ecommerce.domain.models;

public class Product {
    private String name ;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
