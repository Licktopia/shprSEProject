package com.jltechnologies.shopr;



public class Products {//Makes a product object
    private  String mLabel;
    private int mQuantity;
    private double mPrice;
    private int mLocation;

//getters and setters
    public String getLabel() {
        return mLabel;
    }

    public void setLabel(String label) {
        mLabel = label;
    }

    public int getProudctCount() {
        return mQuantity;
    }
    public double getPrice() {return mPrice;}
    public int getLocation() {return mLocation;}

    public void setProudctCount(int quantity) {
        mQuantity = quantity;
    }

    public Products(String label, int quantity, double price, int location){//constructor
        mLabel = label;
        mQuantity = quantity;
        mPrice = price;
        mLocation = location;

    }
}
