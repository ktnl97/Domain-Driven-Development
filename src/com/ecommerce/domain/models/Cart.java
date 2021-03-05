package com.ecommerce.domain.models;

import com.ecommerce.domain.events.DomainEvent;
import com.ecommerce.domain.events.ItemAddedEvent;
import com.ecommerce.domain.events.ItemRemovedEvent;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public final String id;
    private final List<Item> itemList = new ArrayList<>();
    private final List<DomainEvent> events = new ArrayList<>();

    public Cart(String id) {
        this.id = id;
    }

    public void addItem(Item itemToAdd) {
        System.out.println("\nAdding " + itemToAdd + " to the cart:");
        itemList.add(itemToAdd);
        RaiseEvent(new ItemAddedEvent(id, itemToAdd));
        displayItems();
    }

    public void removeItem(Item itemToRemove) {
        System.out.println("\nRemoving " + itemToRemove + " from the cart:");
        itemList.remove(itemToRemove);
        RaiseEvent(new ItemRemovedEvent(id, itemToRemove));
        displayItems();
    }

    private void displayItems() {
        System.out.println("\nItems in the cart are:");
        for (Item items : itemList) {
            System.out.println("Item " + items + " is in cart");
        }
    }

    public List<Item> fetchItems() {
        return itemList;
    }

    private void RaiseEvent(DomainEvent event) {
        events.add(event);
        event.Notify();
    }
}
