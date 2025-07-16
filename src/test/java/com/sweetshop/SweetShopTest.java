package com.sweetshop;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class SweetShopTest {
    //Test Case to Add Sweet.
    @Test
    public void testAddSweet() {
        SweetShop shop = new SweetShop();
        Sweet sweet = new Sweet(1001, "Kaju Katli", "Nut-Based", 50, 20);
        shop.addSweet(sweet);
        assertEquals(1, shop.getAllSweets().size());
        assertEquals("Kaju Katli", shop.getAllSweets().get(0).getName());
    }

    //Test Case for View All Sweets.
    @Test
    public void testViewAllSweets() {
        SweetShop shop = new SweetShop();
        Sweet sweet1 = new Sweet(1001, "Kaju Katli", "Nut-Based", 50, 20);
        Sweet sweet2 = new Sweet(1002, "Gajar Halwa", "Vegetable-Based", 30, 15);
        shop.addSweet(sweet1);
        shop.addSweet(sweet2);
        assertEquals(2, shop.getAllSweets().size());
        assertTrue(shop.getAllSweets().contains(sweet1));
        assertTrue(shop.getAllSweets().contains(sweet2));
    }

    //Test Case for the Delete Sweet.
    @Test
    public void testDeleteSweet() {
        SweetShop shop = new SweetShop();
        Sweet sweet1 = new Sweet(1001, "Kaju Katli", "Nut-Based", 50, 20);
        Sweet sweet2 = new Sweet(1002, "Gajar Halwa", "Vegetable-Based", 30, 15);
        shop.addSweet(sweet1);
        shop.addSweet(sweet2);
        assertEquals(2, shop.getAllSweets().size());
        shop.deleteSweet(1001);
        assertEquals(1, shop.getAllSweets().size());
        assertEquals("Gajar Halwa", shop.getAllSweets().get(0).getName());
    }

    //Test Case for Search Sweet by Name.
    @Test
    public void testSearchSweetByName() {
        SweetShop shop = new SweetShop();
        shop.addSweet(new Sweet(1001, "Kaju Katli", "Nut-Based", 50, 20));
        shop.addSweet(new Sweet(1002, "Gajar Halwa", "Vegetable-Based", 30, 15));
        shop.addSweet(new Sweet(1003, "Gulab Jamun", "Milk-Based", 10, 50));

        assertEquals(1, shop.searchSweetsByName("Kaju Katli").size());
        assertEquals("Kaju Katli", shop.searchSweetsByName("Kaju Katli").get(0).getName());
        assertEquals(0, shop.searchSweetsByName("Rasgulla").size());
    }

    //Test Case for Search Sweet by Category.
    @Test
    public void testSearchSweetByCategory() {
        SweetShop shop = new SweetShop();
        shop.addSweet(new Sweet(1001, "Kaju Katli", "Nut-Based", 50, 20));
        shop.addSweet(new Sweet(1002, "Gajar Halwa", "Vegetable-Based", 30, 15));
        shop.addSweet(new Sweet(1003, "Gulab Jamun", "Milk-Based", 10, 50));
        assertEquals(1, shop.searchSweetsByCategory("Nut-Based").size());
        assertEquals("Kaju Katli", shop.searchSweetsByCategory("Nut-Based").get(0).getName());
        assertEquals(0, shop.searchSweetsByCategory("Fruit-Based").size());
    }

    //Test Case for Search Sweet by PriceRange.
    @Test
    public void testSearchSweetByPriceRange() {
        SweetShop shop = new SweetShop();
        shop.addSweet(new Sweet(1001, "Kaju Katli", "Nut-Based", 50, 20));
        shop.addSweet(new Sweet(1002, "Gajar Halwa", "Vegetable-Based", 30, 15));
        shop.addSweet(new Sweet(1003, "Gulab Jamun", "Milk-Based", 10, 50));
        assertEquals(2, shop.searchSweetsByPriceRange(10, 30).size());
        assertEquals("Gajar Halwa", shop.searchSweetsByPriceRange(10, 30).get(0).getName());
        assertEquals("Gulab Jamun", shop.searchSweetsByPriceRange(10, 30).get(1).getName());
        assertEquals(0, shop.searchSweetsByPriceRange(100, 200).size());
    }

    //Test Case for Search Sweet by Name .
    @Test
    public void testSortSweetsByName() {
        SweetShop shop = new SweetShop();
        shop.addSweet(new Sweet(1002, "Gajar Halwa", "Vegetable-Based", 30, 15));
        shop.addSweet(new Sweet(1001, "Kaju Katli", "Nut-Based", 50, 20));
        shop.addSweet(new Sweet(1003, "Gulab Jamun", "Milk-Based", 10, 50));
        List<Sweet> sorted = shop.sortSweetsByName();
        assertEquals("Gajar Halwa", sorted.get(0).getName());
        assertEquals("Gulab Jamun", sorted.get(1).getName());
        assertEquals("Kaju Katli", sorted.get(2).getName());
    }


}
