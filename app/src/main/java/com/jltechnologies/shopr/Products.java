package com.jltechnologies.shopr;



public class Products {//Makes a product object
    private  String mLabel;
    private int mQuantity;
    private double mPrice;
    private int mLocation;
    private int mPicture;
    private String mLocationName;

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
    public int getPicture(){return mPicture;}
    public String getLocationName(){return mLocationName;}

    public Products(String label, int quantity, double price, int location, int pic, String locName){//constructor
        mLabel=label;
        mQuantity =quantity;
        mPrice = price;
        mLocation = location;
        mPicture = pic;
        mLocationName = locName;

    }
}
