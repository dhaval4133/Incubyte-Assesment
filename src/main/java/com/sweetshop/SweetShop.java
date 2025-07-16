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
    /**
     * Returns a list of all sweets in the shop.
     * @return list of sweets
     */
    public List<Sweet> getAllSweets() {
        return new ArrayList<>(sweets);
    }
    /**
     * Deletes a sweet by its unique ID.
     * @param id the sweet's ID
     */
    public void deleteSweet(int id) {
        sweets.removeIf(sweet -> sweet.getId() == id);
    }
    /**
     * Searches for sweets by name (case-insensitive).
     * @param name the name to search
     * @return list of matching sweets
     */
    public List<Sweet> searchSweetsByName(String name) {
        List<Sweet> result = new ArrayList<>();
        for (Sweet sweet : sweets) {
            if (sweet.getName().equalsIgnoreCase(name)) {
                result.add(sweet);
            }
        }
        return result;
    }


}
