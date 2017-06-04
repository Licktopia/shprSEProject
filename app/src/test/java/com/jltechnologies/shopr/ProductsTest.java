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
        assertEquals(3, item.getProductCount());
        int count = 0;
        count = item.getProductCount();
        assertFalse(count == 0);
        assertEquals(3, count);
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
        item.setProductCount(4);
        assertFalse(item.getProductCount() == 3);
        assertEquals(4, item.getProductCount());
    }

    @Test
    public void getPicture() throws Exception {
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
        assertTrue(pic == 2);
        assertEquals(2, item.getPicture());
        int picnum = 0;
        picnum = item.getPicture();
        assertFalse(picnum == 0);
        assertEquals(2, picnum);
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
        assertTrue(item.getLocationName() instanceof String);
        assertTrue(item.getLocationName() == "Bakery");
        assertEquals("Bakery", item.getLocationName());
        String locationName = item.getLocationName();
        assertTrue(locationName instanceof String);
        assertFalse(locationName == null);
        assertEquals("Bakery", locationName);
    }


}