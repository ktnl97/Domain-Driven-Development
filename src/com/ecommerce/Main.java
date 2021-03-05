package com.ecommerce;

import com.ecommerce.domain.models.Cart;
import com.ecommerce.domain.models.CartManager;
import com.ecommerce.domain.models.Item;
import com.ecommerce.domain.models.Product;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Cart cart =new Cart("1");

        Item ipadItem =new Item("Ipad pro", 1);
        Item heroInkPenItem =new Item("Hero Ink Pen", 1);
        Item gmCricketBatItem =new Item("GM Cricket bat", 2);

        cart.addItem(ipadItem);
        cart.addItem(heroInkPenItem);
        cart.addItem(gmCricketBatItem);

        cart.removeItem(ipadItem);

        CartManager cartManager = CartManager.getCartManager();
        List<Product> deletedProducts = cartManager.fetchDeletedProducts(cart.id);
        System.out.println("\nProducts that were deleted from the cart are:");
        deletedProducts.forEach(System.out::println);
    }
}
