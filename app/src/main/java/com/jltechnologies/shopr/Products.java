package com.jltechnologies.shopr;

/**
 * Created by jeff on 12/14/16.
 */

public class Products {
    private  String mLabel;
    private int mQuantity;
    private double mPrice;
    private int mLocation;


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

    public Products(String label, int quantity, double price, int location){
        mLabel=label;
        mQuantity =quantity;
        mPrice = price;
        mLocation = location;

    }
}
