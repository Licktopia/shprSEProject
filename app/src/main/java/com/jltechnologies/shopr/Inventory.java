package com.jltechnologies.shopr;

import java.util.ArrayList;

/**
 * Created by do_de on 5/18/2017.
 */

public class Inventory {

    public class Store{
        Store(String sName, String[] productos, double[] precios, int[] loc, String[] locNames){//constructor
            storeName = sName;
            products = productos;
            prices = precios;
            location = loc;
            locationNames = locNames;
        }
        String storeName;
        String[] products;
        double[] prices;
        int[] location;
        String[] locationNames;
    }


//producs, prices, and location are parrelel arrays and must be the same length at each store. Location name array string corresponds to the location number
    public String[]   products1 = {"Eggs","Ham","Eyedrops","Sausage","Crackers","Toilet Paper","Cereal","Tylenol","Sugar","Bread","Wine","Shrimp","Ice Cream"};
    public double[]   prices1   = {1.99,   2.49, 5.69,      3.99,     2.58,      .99,           2.99,     6.75,    .59,     1.09,  10.59, 12.99,   4.99      };
    public int[]      location1 = {6,      6,    4,         11,       6,          5,            6,        4,       7,      8,      9,     10,      10        };
    public String[]   locationName1 = {"Left Entrance", "Cashier", "Right Entrance", "Pharmacy", "Aisle 1", "Aisle 2", "Aisle 3", "Bakery", "Aisle 4", "Aisle 5", "Aisle 6" };
    Store store1 = new Store("Garland Corner Market", products1, prices1, location1, locationName1);

    public String[]   products2 = {"Eggs","Ham","Eyedrops","Sausage","Crackers","Toilet Paper","Cereal","Tylenol","Sugar","Bread","Wine","Shrimp","Ice Cream"};
    public double[]   prices2   = {1.99,   2.49, 5.69,      3.99,     2.58,      .99,           2.99,     6.75,    .59,     1.09,  10.59, 12.99,   4.99      };
    public int[]      location2 = {6,      6,    4,         11,       6,          5,            6,        4,       7,      8,      9,     10,      10        };
    public String[]   locationName2 = {"Left Entrance", "Cashier", "Right Entrance", "Pharmacy", "Aisle 1", "Aisle 2", "Aisle 3", "Bakery", "Aisle 4", "Aisle 5", "Aisle 6" };
    Store store2 = new Store("Market of Choice Camarillo", products2, prices2, location2, locationName2);

    public String[]   products3 = {"Eggs","Ham","Eyedrops","Sausage","Crackers","Toilet Paper","Cereal","Tylenol","Sugar","Bread","Wine","Shrimp","Ice Cream"};
    public double[]   prices3   = {1.99,   2.49, 5.69,      3.99,     2.58,      .99,           2.99,     6.75,    .59,     1.09,  10.59, 12.99,   4.99      };
    public int[]      location3 = {6,      6,    4,         11,       6,          5,            6,        4,       7,      8,      9,     10,      10        };
    public String[]   locationName3 = {"Left Entrance", "Cashier", "Right Entrance", "Pharmacy", "Aisle 1", "Aisle 2", "Aisle 3", "Bakery", "Aisle 4", "Aisle 5", "Aisle 6" };
    Store store3 = new Store("Safeway Juliaville", products3, prices3, location3, locationName3);

    public String[]   products4 = {"Eggs","Ham","Eyedrops","Sausage","Crackers","Toilet Paper","Cereal","Tylenol","Sugar","Bread","Wine","Shrimp","Ice Cream"};
    public double[]   prices4   = {1.99,   2.49, 5.69,      3.99,     2.58,      .99,           2.99,     6.75,    .59,     1.09,  10.59, 12.99,   4.99      };
    public int[]      location4 = {6,      6,    4,         11,       6,          5,            6,        4,       7,      8,      9,     10,      10        };
    public String[]   locationName4 = {"Left Entrance", "Cashier", "Right Entrance", "Pharmacy", "Aisle 1", "Aisle 2", "Aisle 3", "Bakery", "Aisle 4", "Aisle 5", "Aisle 6" };
    Store store4 = new Store("Newton Market", products4, prices4, location4, locationName4);

    public String[]   products5 = {"Eggs","Milk","Orange Juice","Ham","Eyedrops","Raspberries","Sausage","Paper Towels","Tylenol","Bagels","Bread","Donuts","Beer","Lean Beef","Cream Cheese","Ice Cream"};
    public double[]   prices5   = {2.49,   1.99,  2.99,          3.99, 5.49,      4.99,         2.99,     5.49,          6.99,     0.79,    1.19,   0.59,    9.99,  11.49,      3.49,          4.99      };
    public int[]      location5 = {10,     10,    10,            8,    6,         4,            8,        11,            6,        7,       7,      7,       9,     5,          10,            10,       };
    public String[]   locationName5 = {"Left Entrance", "Cashier", "Right Entrance", "Produce", "Fresh Meat", "Pharmacy", "Bakery", "Deli", "Aisle 1", "Aisle 2", "Aisle 3", "Aisle 4", "Aisle 5", "Aisle 6"};
    Store store5 = new Store("Market of Choice Eugene", products5, prices5, location5, locationName5);

    public Store[] mStores = {store1,store2,store3,store4,store5};//array of Stores

}
