package com.ecommerce.domain.events;

import com.ecommerce.domain.models.CartManager;
import com.ecommerce.domain.models.Item;

public class ItemRemovedEvent implements DomainEvent {
    private String cartId;
    private Item itemAdded;
    private CartManager cartManager;

    public ItemRemovedEvent(String cartId, Item itemAdded) {
        this.cartId = cartId;
        this.itemAdded = itemAdded;
        cartManager = CartManager.getCartManager();
    }

    public void Notify() {
        cartManager.handleItemRemoval(cartId, itemAdded.getProduct());
    }
}
