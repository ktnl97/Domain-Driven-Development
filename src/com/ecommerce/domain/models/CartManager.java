package com.ecommerce.domain.models;

import java.util.*;

public class CartManager {
    private Hashtable<String, List<Product>> deletedProductsLog = new Hashtable();
    private static CartManager _CartManager = null;

    private CartManager() {
        _CartManager = this;
    }

    public static CartManager getCartManager() {
        if (_CartManager != null) {
            return _CartManager;
        }
        return new CartManager();
    }

    public List<Product> fetchDeletedProducts(String cartId){
        return deletedProductsLog.get(cartId);
    }

    public void handleItemAddition(String cartId, Product productAdded) {
        System.out.println("Handling Item "+ productAdded +" addition to cart with Id " + cartId);
        if(deletedProductsLog.containsKey(cartId)) {
            List<Product> deletedProducts = deletedProductsLog.get(cartId);
            if(deletedProducts.contains(productAdded)) {
                deletedProducts.remove(productAdded);
            }
        }
    }

    public void handleItemRemoval(String cartId, Product productDeleted) {
        System.out.println("Handling Item "+ productDeleted +" removal from cart with Id " + cartId);
        if(deletedProductsLog.containsKey(cartId)) {
            List<Product> deletedProducts = deletedProductsLog.get(cartId);
            if(!deletedProducts.contains(productDeleted)) {
                deletedProducts.add(productDeleted);
            }
        }
        else {
            deletedProductsLog.put(cartId, Arrays.asList(productDeleted));
        }
    }
}
