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


}
