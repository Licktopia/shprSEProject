package com.jltechnologies.shopr;

import org.junit.Test;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import static org.junit.Assert.*;

import java.util.*;
import java.lang.*;

/**
 * Created by Omeed on 6/1/17.
 */
public class ShoppingCartActivityTest {

    Menu menu;
    Bundle bundle;
    @Test
    public void onCreate() throws Exception {

    }

    @Test
    public void onPause() throws Exception {

    }

    @Test
    public void updateTotal() throws Exception {

    }

    @Test
    public void onRadioButtonClicked() throws Exception {

    }

    @Test
    public void onCreateOptionsMenu() throws Exception {
        /*ShoppingCartActivity scactivity = new ShoppingCartActivity();
        Menu menu = new Menu();
        assertEquals(true, scactivity.onCreateOptionsMenu(menu));*/
    }

    @Test
    public void onOptionsItemSelected() throws Exception {

    }

    @Test
    public void onBackPressed() throws Exception {

    }


    @Test
    public void AlphSorterTest() throws Exception {
        Products item1 = new Products("Bread", 3, 1.99, 8, 9, "The Bakery");
        Products item2 = new Products("Bagels", 3, 0.99, 8, 13, "The Bakery");
        Products item3 = new Products("Donuts", 2, 0.79, 8, 16, "The Bakery");
        ShoppingCartActivity scactivity = new ShoppingCartActivity();
        ShoppingCartActivity.AlphSorter alphsorter = scactivity.new AlphSorter();
        assertFalse(alphsorter.compare(item1, item2) <= 0);
        assertTrue(alphsorter.compare(item1, item2) > 0);
        assertFalse(alphsorter.compare(item2, item1) > 0);
        assertTrue(alphsorter.compare(item2, item1) <= 0);
        assertTrue(alphsorter.compare(item1, item1) == 0);
        assertTrue(alphsorter.compare(item2, item2) == 0);
        Products[] items = {item1, item2, item3};
        Products temp;
        int changes;
        do {
            changes = 0;
            for (int i = 0; i < items.length - 1; i++) {
                if (alphsorter.compare(items[i], items[i+1]) > 0) {
                    temp = items[i];
                    items[i] = items[i+1];
                    items[i+1] = temp;
                    changes++;
                }

            }
        } while (changes > 0);
        for (int i = 0; i < items.length - 1; i++) {
            assertTrue(alphsorter.compare(items[i], items[i+1]) <= 0);
        }

    }

    @Test
    public void PriceSorterTest() throws Exception {
        Products item1 = new Products("Bread", 3, 1.99, 8, 9, "The Bakery");
        Products item2 = new Products("Bagels", 3, 0.99, 8, 13, "The Bakery");
        Products item3 = new Products("Donuts", 2, 0.79, 8, 16, "The Bakery");
        ShoppingCartActivity scactivity = new ShoppingCartActivity();
        ShoppingCartActivity.PriceSorter pricesorter = scactivity.new PriceSorter();
        assertFalse(pricesorter.compare(item1, item2) <= 0);
        assertTrue(pricesorter.compare(item1, item2) == 1);
        assertFalse(pricesorter.compare(item2, item1) >= 0);
        assertTrue(pricesorter.compare(item2, item1) == -1);
        assertTrue(pricesorter.compare(item1, item1) == 0);
        assertTrue(pricesorter.compare(item2, item2) == 0);
        Products[] items = {item1, item2, item3};
        Products temp;
        int changes;
        do {
            changes = 0;
            for (int i = 0; i < items.length - 1; i++) {
                if (pricesorter.compare(items[i], items[i+1]) > 0) {
                    temp = items[i];
                    items[i] = items[i+1];
                    items[i+1] = temp;
                    changes++;
                }

            }
        } while (changes > 0);
        for (int i = 0; i < items.length - 1; i++) {
            assertTrue(pricesorter.compare(items[i], items[i+1]) <= 0);
        }
    }

    @Test
    public void LocSorterTest() throws Exception {
        Products item1 = new Products("Bread", 3, 1.99, 8, 9, "The Bakery");
        Products item2 = new Products("Bagels", 3, 0.99, 8, 13, "The Bakery");
        Products item3 = new Products("Donuts", 2, 0.79, 8, 16, "The Bakery");
        ShoppingCartActivity scactivity = new ShoppingCartActivity();
        ShoppingCartActivity.LocSorter locsorter = scactivity.new LocSorter();
        assertFalse(locsorter.compare(item1, item2) < 0);
        assertTrue(locsorter.compare(item1, item2) == 0);
        assertFalse(locsorter.compare(item2, item1) > 0);
        assertTrue(locsorter.compare(item2, item1) == 0);
        assertTrue(locsorter.compare(item1, item1) == 0);
        assertTrue(locsorter.compare(item2, item2) == 0);
        Products[] items = {item1, item2, item3};
        Products temp;
        int changes;
        do {
            changes = 0;
            for (int i = 0; i < items.length - 1; i++) {
                if (locsorter.compare(items[i], items[i+1]) > 0) {
                    temp = items[i];
                    items[i] = items[i+1];
                    items[i+1] = temp;
                    changes++;
                }

            }
        } while (changes > 0);
        for (int i = 0; i < items.length - 1; i++) {
            assertTrue(locsorter.compare(items[i], items[i + 1]) == 0);
        }
    }

}