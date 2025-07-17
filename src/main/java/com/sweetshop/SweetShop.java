package com.sweetshop;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;


/**
 * SweetShop manages the inventory and operations for sweets in the shop.
 * Supports add, delete, search, sort, purchase, and restock operations.
 */
public class SweetShop {

    private static final String ERROR_NOT_ENOUGH_STOCK = "Not enough stock available";
    private static final String ERROR_SWEET_NOT_FOUND = "Sweet not found";

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

    /**
     * Searches for sweets by category (case-insensitive).
     * @param category the category to search
     * @return list of matching sweets
     */
    public List<Sweet> searchSweetsByCategory(String category) {
        List<Sweet> result = new ArrayList<>();
        for (Sweet sweet : sweets) {
            if (sweet.getCategory().equalsIgnoreCase(category)) {
                result.add(sweet);
            }
        }
        return result;
    }

    /**
     * Searches for sweets within a price range.
     * @param minPrice minimum price
     * @param maxPrice maximum price
     * @return list of matching sweets
     */
    public List<Sweet> searchSweetsByPriceRange(double minPrice, double maxPrice) {
        List<Sweet> result = new ArrayList<>();
        for (Sweet sweet : sweets) {
            if (sweet.getPrice() >= minPrice && sweet.getPrice() <= maxPrice) {
                result.add(sweet);
            }
        }
        return result;
    }

    /**
     * Returns a list of sweets sorted by name.
     * @return sorted list
     */
    public List<Sweet> sortSweetsByName() {
        List<Sweet> sorted = new ArrayList<>(sweets);
        sorted.sort(Comparator.comparing(Sweet::getName));
        return sorted;
    }

    /**
     * Returns a list of sweets sorted by quantity.
     * @return sorted list
     */
    public List<Sweet> sortSweetsByQuantity() {
        List<Sweet> sorted = new ArrayList<>(sweets);
        sorted.sort(Comparator.comparingInt(Sweet::getQuantity));
        return sorted;
    }

    /**
     * Returns a list of sweets sorted by price.
     * @return sorted list
     */
    public List<Sweet> sortSweetsByPrice() {
        List<Sweet> sorted = new ArrayList<>(sweets);
        sorted.sort(Comparator.comparingDouble(Sweet::getPrice));
        return sorted;
    }

    /**
     * Purchases a quantity of a sweet, reducing its stock.
     * @param id sweet ID
     * @param quantity quantity to purchase
     * @throws IllegalArgumentException if not enough stock or sweet not found
     */
    public void purchaseSweet(int id, int quantity) {
        for (Sweet sweet : sweets) {
            if (sweet.getId() == id) {
                if (sweet.getQuantity() < quantity) {
                    throw new IllegalArgumentException(ERROR_NOT_ENOUGH_STOCK);
                }
                sweet.setQuantity(sweet.getQuantity() - quantity);
                return;
            }
        }
        throw new IllegalArgumentException(ERROR_SWEET_NOT_FOUND);
    }




}
