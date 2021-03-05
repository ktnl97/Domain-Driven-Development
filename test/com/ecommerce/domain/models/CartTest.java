package com.ecommerce.domain.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    private Cart cart;
    @BeforeEach
    void setUp() {
        cart = new Cart("2");
    }

    @Test
    void addItem_ShouldAddGivenItemToCart() {
        Item ipadPro = new Item("Ipad Pro", 1);

        cart.addItem(ipadPro);

        assertTrue(cart.fetchItems().contains(ipadPro));
    }

    @Test
    void addItem_ShouldAddItemToCartWithGivenProductAndQuantity() {
        Item gmCricketBat = new Item("GM Cricket Bat", 2);

        cart.addItem(gmCricketBat);

        List<Item> addedItems = cart.fetchItems();
        assertEquals(gmCricketBat, addedItems.get(addedItems.indexOf(gmCricketBat)));
    }

    @Test
    void removeItem_ShouldRemoveGivenItemFromCart() {
        Item heroInkPen = new Item("Hero ink Pen", 2);
        cart.addItem(heroInkPen);

        cart.removeItem(heroInkPen);

        assertFalse(cart.fetchItems().contains(heroInkPen));
    }

    @Test
    void ShouldReturnTrueIfSameCartIsCompared() {
        Cart cart1 = new Cart("1");
        assertEquals(cart1, cart1);
    }

    @Test
    void ShouldReturnFalseIfSameProductContainingCartsAreCompared() {
        String productName = "Ipad Pro";
        Cart cart1 = new Cart("1");
        Cart cart2 = new Cart("2");
        Item item1 = new Item(productName,1);
        cart1.addItem(item1);
        Item item2 = new Item(productName,1);
        cart2.addItem(item2);
        assertNotEquals(cart1, cart2);
    }
}
