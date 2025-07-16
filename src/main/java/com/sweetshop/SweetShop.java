package com.sweetshop;
import java.util.List;
import java.util.ArrayList;


/**
 * SweetShop manages the inventory and operations for sweets in the shop.
 * Supports add, delete, search, sort, purchase, and restock operations.
 */
public class SweetShop {
    /**
     * Constructs a new SweetShop with an empty inventory.
     */
    public SweetShop() {
        this.sweets = new ArrayList<>();
    }
    private final List<Sweet> sweets;
    /**
     * Adds a new sweet to the shop.
     * @param sweet the sweet to add
     */
    public void addSweet(Sweet sweet) {
        this.sweets.add(sweet);
    }


}
