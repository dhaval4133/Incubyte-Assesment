package com.sweetshop;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class SweetShopTest {
    @Test
    public void testAddSweet() {
        SweetShop shop = new SweetShop();
        Sweet sweet = new Sweet(1001, "Kaju Katli", "Nut-Based", 50, 20);
        shop.addSweet(sweet);
        assertEquals(1, shop.getAllSweets().size());
        assertEquals("Kaju Katli", shop.getAllSweets().get(0).getName());
    }
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

}
