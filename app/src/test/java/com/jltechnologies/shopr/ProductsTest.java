package com.jltechnologies.shopr;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Omeed on 6/1/17.
 */
public class ProductsTest {
    @Test
    public void getLabel() throws Exception {
        String label = "Bread";
        int quantity = 3;
        double price = 1.99;
        int location = 8;
        int pic = 2;
        String locName = "Bakery";
        Products item = new Products(label,
                quantity,
                price,
                location,
                pic,
                locName);
        assertFalse(item.getLabel() == null);
        assertEquals("Bread", item.getLabel());
    }

    @Test
    public void setLabel() throws Exception {
        String label = "Bread";
        int quantity = 3;
        double price = 1.99;
        int location = 8;
        int pic = 2;
        String locName = "Bakery";
        Products item = new Products(label,
                quantity,
                price,
                location,
                pic,
                locName);
        item.setLabel("Bagels");
        assertTrue(item.getLabel() instanceof String);
        assertFalse(item.getLabel() == "Bread");
        assertEquals("Bagels", item.getLabel());

    }

    @Test
    public void getProductCount() throws Exception {

    }

    @Test
    public void getPrice() throws Exception {
        String label = "Bread";
        int quantity = 3;
        double price = 1.99;
        int location = 8;
        int pic = 2;
        String locName = "Bakery";
        Products item = new Products(label,
                quantity,
                price,
                location,
                pic,
                locName);
        assertEquals(1.99, item.getPrice(), 0);
        String finalPrice = String.valueOf(item.getPrice());
        assertTrue(finalPrice.contains("."));
        assertEquals("1.99", finalPrice);
    }

    @Test
    public void getLocation() throws Exception {
        String label = "Bread";
        int quantity = 3;
        double price = 1.99;
        int location = 8;
        int pic = 2;
        String locName = "Bakery";
        Products item = new Products(label,
                quantity,
                price,
                location,
                pic,
                locName);
        assertEquals(8, item.getLocation());
        int itemLoc = 0;
        itemLoc = item.getLocation();
        assertFalse(itemLoc == 0);
        assertEquals(8, itemLoc);
    }

    @Test
    public void setProductCount() throws Exception {

    }

    @Test
    public void getPicture() throws Exception {
        String label = "Bread";
        int quantity = 3;
        double price = 1.99;
        int location = 8;
        int pic = 2;
        String locName = "Bakery";
        Products bread = new Products(label,
                quantity,
                price,
                location,
                pic,
                locName);
        assertTrue(pic==2);
    }


    @Test
    public void getLocationName() throws Exception {
        String label = "Bread";
        int quantity = 3;
        double price = 1.99;
        int location = 8;
        int pic = 2;
        String locName = "Bakery";
        Products item = new Products(label,
                quantity,
                price,
                location,
                pic,
                locName);
        assertTrue(item.getLocationName() == "Bakery");
        assertEquals("Bakery", item.getLocationName());
    }


}