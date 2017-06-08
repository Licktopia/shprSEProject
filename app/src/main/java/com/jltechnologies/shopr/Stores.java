package com.jltechnologies.shopr;

import java.util.ArrayList;

/**
 * Created by do_de on 5/18/2017.
 */

public class Stores {
    public int[] foodTags = {R.drawable.eggs,
      R.drawable.ham,
      R.drawable.eyedrops,
      R.drawable.sausage,
      R.drawable.crackers,
      R.drawable.toiletpaper,
      R.drawable.cereal,
      R.drawable.tylenol,
      R.drawable.sugar,
      R.drawable.bread,
      R.drawable.wine,
      R.drawable.shrimp,
      R.drawable.icecream,
      R.drawable.bagels,
      R.drawable.beer,
      R.drawable.creamcheese,
      R.drawable.donuts,
      R.drawable.leanbeef,
      R.drawable.milk,
      R.drawable.orangejuice,
      R.drawable.papertowels,
      R.drawable.raspberries};

    public class Store{
        Store(String sName, String[] productos, double[] precios, int[] loc, int[] pictureTags, String[] locNames){//constructor
            storeName = sName;
            products = productos;
            prices = precios;
            location = loc;
            picTags = pictureTags;
            locationNames = locNames;
        }
        String storeName;
        String[] products;
        double[] prices;
        int[] location;
        String[] locationNames;
        int[] picTags;
    }


//producs, prices, and location are parrelel arrays and must be the same length at each store. Location name array string corresponds to the location number
    public String[]   products1     = {"Eggs",     "Ham",      "Eyedrops", "Sausage"  ,"Crackers" ,"Toilet Paper","Cereal",   "Tylenol",  "Sugar",    "Bread",    "Wine",      "Shrimp",    "Ice Cream" };
    public double[]   prices1       = {1.99,       2.49,       5.69,       3.99,       2.58,       .99,           2.99,       6.75,       .59,        1.09,       10.59,       12.99,       4.99        };
    public int[]      location1     = {8,          8,          4,          17,         7,          6,             7,          4,          9,          11,         5,           15,          12          };
    public int[]      pictureTags1  = {foodTags[0],foodTags[1],foodTags[2],foodTags[3],foodTags[4],foodTags[5],   foodTags[6],foodTags[7],foodTags[8],foodTags[9],foodTags[10],foodTags[11],foodTags[12]};
    public String[]   locationName1 = {"The Left Entrance", "The Cashier", "The Right Entrance", "The Pharmacy", "Aisle 1 Front", "Aisle 1 Rear", "Aisle 2 Front", "Aisle 2 Rear", "Aisle 3 Front", "Aisle 3 Rear",
                                       "The Bakery", "Aisle 4 Front", "Aisle 4 Rear", "Aisle 5 Front", "Aisle 5 Rear", "Aisle 6 Front", "Aisle 6 Rear"};
    Store store1 = new Store("Garland Corner Market", products1, prices1, location1, pictureTags1, locationName1);

    public String[]   products2     = {"Eggs",     "Ham",      "Eyedrops", "Sausage"  ,"Crackers" ,"Toilet Paper","Cereal",   "Tylenol",  "Sugar",    "Bread",    "Wine",      "Shrimp",    "Ice Cream" };
    public double[]   prices2       = {1.99,       2.49,       5.69,       3.99,       2.58,       .99,           2.99,       6.75,       .59,        1.09,       10.59,       12.99,       4.99        };
    public int[]      location2     = {8,          8,          4,          17,         7,          6,             7,          4,          9,          11,         5,           15,          12          };
    public int[]      pictureTags2  = {foodTags[0],foodTags[1],foodTags[2],foodTags[3],foodTags[4],foodTags[5],   foodTags[6],foodTags[7],foodTags[8],foodTags[9],foodTags[10],foodTags[11],foodTags[12]};
    public String[]   locationName2 = {"The Left Entrance", "The Cashier", "The Right Entrance", "The Pharmacy", "Aisle 1 Front", "Aisle 1 Rear", "Aisle 2 Front", "Aisle 2 Rear", "Aisle 3 Front", "Aisle 3 Rear",
                                       "The Bakery", "Aisle 4 Front", "Aisle 4 Rear", "Aisle 5 Front", "Aisle 5 Rear", "Aisle 6 Front", "Aisle 6 Rear"};
    Store store2 = new Store("Market of Choice Camarillo", products2, prices2, location2, pictureTags2, locationName2);

    public String[]   products3     = {"Eggs",     "Ham",      "Eyedrops", "Sausage"  ,"Crackers" ,"Toilet Paper","Cereal",   "Tylenol",  "Sugar",    "Bread",    "Wine",      "Shrimp",    "Ice Cream" };
    public double[]   prices3       = {1.99,       2.49,       5.69,       3.99,       2.58,       .99,           2.99,       6.75,       .59,        1.09,       10.59,       12.99,       4.99        };
    public int[]      location3     = {8,          8,          4,          17,         7,          6,             7,          4,          9,          11,         5,           15,          12          };
    public int[]      pictureTags3  = {foodTags[0],foodTags[1],foodTags[2],foodTags[3],foodTags[4],foodTags[5],   foodTags[6],foodTags[7],foodTags[8],foodTags[9],foodTags[10],foodTags[11],foodTags[12]};
    public String[]   locationName3 = {"The Left Entrance", "The Cashier", "The Right Entrance", "The Pharmacy", "Aisle 1 Front", "Aisle 1 Rear", "Aisle 2 Front", "Aisle 2 Rear", "Aisle 3 Front", "Aisle 3 Rear",
                                       "The Bakery", "Aisle 4 Front", "Aisle 4 Rear", "Aisle 5 Front", "Aisle 5 Rear", "Aisle 6 Front", "Aisle 6 Rear"};
    Store store3 = new Store("Safeway Juliaville", products3, prices3, location3, pictureTags3, locationName3);

    public String[]   products4     = {"Eggs",     "Ham",      "Eyedrops", "Sausage"  ,"Crackers" ,"Toilet Paper","Cereal",   "Tylenol",  "Sugar",    "Bread",    "Wine",      "Shrimp",    "Ice Cream" };
    public double[]   prices4       = {1.99,       2.49,       5.69,       3.99,       2.58,       .99,           2.99,       6.75,       .59,        1.09,       10.59,       12.99,       4.99        };
    public int[]      location4     = {8,          8,          4,          17,         7,          6,             7,          4,          9,          11,         5,           15,          12          };
    public int[]      pictureTags4  = {foodTags[0],foodTags[1],foodTags[2],foodTags[3],foodTags[4],foodTags[5],   foodTags[6],foodTags[7],foodTags[8],foodTags[9],foodTags[10],foodTags[11],foodTags[12]};
    public String[]   locationName4 = {"The Left Entrance", "The Cashier", "The Right Entrance", "The Pharmacy", "Aisle 1 Front", "Aisle 1 Rear", "Aisle 2 Front", "Aisle 2 Rear", "Aisle 3 Front", "Aisle 3 Rear",
                                       "The Bakery", "Aisle 4 Front", "Aisle 4 Rear", "Aisle 5 Front", "Aisle 5 Rear", "Aisle 6 Front", "Aisle 6 Rear"};
    Store store4 = new Store("Newton Market", products4, prices4, location4, pictureTags4, locationName4);

    public String[]   products5     = {"Eggs",     "Milk",      "Orange Juice","Ham",      "Eyedrops", "Raspberries","Sausage",  "Paper Towels","Tylenol",  "Bagels",    "Bread",    "Donuts",    "Beer",      "Lean Beef", "Cream Cheese","Ice Cream" };
    public double[]   prices5       = {2.49,       1.99,        2.99,          3.99,       5.49,       4.99,         2.99,       5.49,          6.99,       0.79,        1.19,       0.59,        9.99,        11.49,       3.49,          4.99        };
    public int[]      location5     = {12,         12,          11,            8,          6,          4,            8,          14,            6,          7,           7,          7,           9,           5,           12,            12,         };
    public int[]      pictureTags5  = {foodTags[0],foodTags[18],foodTags[19],  foodTags[1],foodTags[2],foodTags[21], foodTags[3],foodTags[20],  foodTags[7],foodTags[13],foodTags[9],foodTags[16],foodTags[14],foodTags[17],foodTags[15],  foodTags[12]};
    public String[]   locationName5 = {"The Left Entrance", "The Cashier", "The Right Entrance", "Produce", "Fresh Meat", "The Pharmacy", "The Bakery", "The Deli", "Aisle 1 Front", "Aisle 1 Rear", "Aisle 2 Front", "Aisle 2 Rear", "Aisle 3 Front", "Aisle 3 Rear",
                                       "Aisle 4 Front", "Aisle 4 Rear", "Aisle 5 Front", "Aisle 5 Rear", "Aisle 6 Front", "Aisle 6 Rear"};
    Store store5 = new Store("Market of Choice Eugene", products5, prices5, location5, pictureTags5, locationName5);


    public String[]   products6     = {"Eggs",     "Milk",      "Orange Juice","Ham",      "Eyedrops", "Raspberries","Sausage",  "Paper Towels","Tylenol",  "Bagels",    "Bread",    "Donuts",    "Beer",      "Lean Beef", "Cream Cheese","Ice Cream" };
    public double[]   prices6       = {2.49,       1.99,        2.99,          3.99,       5.49,       4.99,         2.99,       5.49,          6.99,       0.79,        1.19,       0.59,        9.99,        11.49,       3.49,          4.99        };
    public int[]      location6     = {12,         12,          11,            8,          6,          4,            8,          14,            6,          7,           7,          7,           9,           5,           12,            12,         };
    public int[]      pictureTags6  = {foodTags[0],foodTags[18],foodTags[19],  foodTags[1],foodTags[2],foodTags[21], foodTags[3],foodTags[20],  foodTags[7],foodTags[13],foodTags[9],foodTags[16],foodTags[14],foodTags[17],foodTags[15],  foodTags[12]};
    public String[]   locationName6 = {"The Left Entrance", "The Cashier", "The Right Entrance", "Produce", "Fresh Meat", "The Pharmacy", "The Bakery", "The Deli", "Aisle 1 Front", "Aisle 1 Rear", "Aisle 2 Front", "Aisle 2 Rear", "Aisle 3 Front", "Aisle 3 Rear",
            "Aisle 4 Front", "Aisle 4 Rear", "Aisle 5 Front", "Aisle 5 Rear", "Aisle 6 Front", "Aisle 6 Rear"};
    Store store6 = new Store("Market of Choice Corvallis", products6, prices6, location6, pictureTags6, locationName6);

    public Store[] mStores = {store1,store2,store3,store4,store5,store6};//array of Stores

}
