package com.jltechnologies.shopr;

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


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ShoppingCartActivity extends AppCompatActivity {
    String STORE = "storenumber";
    private static final String PREFS_FILE = "com.jltechnologies.shopr.preferences";
    private static final String KEY_STROKECOUNT = "key_strokecount";
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    public static ArrayList <Products> mProductses = new ArrayList<Products>();
    private ListAdapter mListAdapter;
    public static Stores mInventory;
    public static TextView mTotal;
    private Button mFindRoute;
    private TextView mStoreTitle;
    public static boolean leftEntrance = true;
    static int storeNumber;
    private boolean backout;
    private static boolean clearOut;
    Toolbar toolbar;
    Button mAlphSort;
    Button mPriceSort;
    Button mLocSort;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ListView list = (ListView) findViewById(android.R.id.list);//list is scrolling view that is dynamically populated
        /////////bindings
        mTotal = (TextView)findViewById(R.id.total_amount);
        mFindRoute = (Button)findViewById(R.id.find_route); //initialize find route button
        mPriceSort = (Button)findViewById(R.id.price_sort); //initialize find route button
        mLocSort = (Button)findViewById(R.id.loc_sort); //initialize find route button
        mAlphSort = (Button)findViewById(R.id.alph_sort); //initialize find route button
        mStoreTitle = (TextView) findViewById(R.id.store_title); //initialize find route button

        mSharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);//shared preferences saves variable states for when the app is paused or looses focus
        mEditor = mSharedPreferences.edit();
        backout = false;
        mInventory = new Stores();//create inventory object that gives us access to store products, prices and product locations
        clearOut = getIntent().getExtras().getBoolean("clearCart");
        storeNumber = getIntent().getExtras().getInt("storeNumber"); //gets Store Number from start screen activity



        mStoreTitle.setText(mInventory.mStores[storeNumber].storeName);//set text for top of screen title  ie "Juliaville Shopping List"


        int products = 0;
        if(clearOut){
            mProductses.clear();
        }
        System.out.println(mInventory.mStores[storeNumber].products.length);

        for (int i = 0; i < mInventory.mStores[storeNumber].products.length; i++) {////retrieve saved data from shared preferences
                if(!clearOut) {
                    products = mSharedPreferences.getInt(KEY_STROKECOUNT + i, 0);
                }
                else{
                    products=0;
                }
                mProductses.add(new Products(mInventory.mStores[storeNumber].products[i], products,
                        mInventory.mStores[storeNumber].prices[i], mInventory.mStores[storeNumber].location[i],
                        mInventory.mStores[storeNumber].picTags[i],mInventory.mStores[storeNumber].locationNames[mInventory.mStores[storeNumber].location[i]-1]));
            }

        mListAdapter = new ListAdapter(this, mProductses);////list adapter is adapter class that binds info to the list view
        list.setAdapter(mListAdapter);
        Collections.sort(mProductses,new AlphSorter());
        mListAdapter.notifyDataSetChanged();

        if(!clearOut) {
            updateTotal();//display $$$ Total
        }
        else{
            mTotal.setText("$0.00");
        }
        clearOut = false;


        mFindRoute.setOnClickListener(new View.OnClickListener() {//click listener for Find Route Button
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingCartActivity.this, FindRouteActivity.class);//state intent to go to Find Route class
                startActivity(intent);//GO
            }
        });

        mAlphSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(mProductses,new AlphSorter());
                mListAdapter.notifyDataSetChanged();
            }
        });

        mPriceSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(mProductses,new PriceSorter());
                mListAdapter.notifyDataSetChanged();
            }
        });

        mLocSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.sort(mProductses,new LocSorter());
                mListAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onPause() {//on pause save shopping list
        super.onPause();
        if(!backout) {
            for (int i = 0; i < mInventory.mStores[storeNumber].products.length; i++) {
                mEditor.putInt(KEY_STROKECOUNT + i, mProductses.get(i).getProductCount());
            }
        }
        mEditor.apply();
    }

    public static void updateTotal(){//function iterates through shopping list and sets and displays total amount $$$
        double total = 0.0;
        if(!clearOut) {
            for (int i = 0; i < mInventory.mStores[storeNumber].products.length; i++) {
                total += mProductses.get(i).getProductCount() * mProductses.get(i).getPrice();
            }
        }
        DecimalFormat df = new DecimalFormat("#.##");
        total = Double.valueOf(df.format(total));
        mTotal.setText("$"+total);
        clearOut=false;

    }

    public void onRadioButtonClicked(View view) {//Select Left or Right Entrance
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.left_radio:
                if (checked)
                    leftEntrance = true;
                    break;
            case R.id.right_radio:
                if (checked)
                    leftEntrance = false;
                    break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_clear_strokes) {
            mEditor.clear();
            mEditor.apply();

            for(Products products : mProductses){
                products.setProductCount(0);
            }
            mListAdapter.notifyDataSetChanged();//updates List Adapter when clear cart clicked, otherwise data changed but view not refreshed
            updateTotal();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        clearList();


        Intent intent = new Intent(ShoppingCartActivity.this, StartScreenActivity.class);//state intent to go to Find Route class
        StartScreenActivity.ed.putInt(STORE, storeNumber);
        StartScreenActivity.ed.apply();
        startActivity(intent);//GO
    }

    private void clearList() {
        backout = true;
        clearOut = false;
        mProductses.clear();
        mListAdapter.notifyDataSetChanged();
        mEditor.clear();
        mEditor.apply();
    }

    public class AlphSorter implements Comparator<Products> {

        public int compare(Products one, Products another){

            int returnVal = one.getLabel().compareTo(another.getLabel());

            return returnVal;

        }
    }

    public class PriceSorter implements Comparator<Products> {

        public int compare(Products one, Products another){
            int returnVal = 0;

            if(one.getPrice() > another.getPrice()){
                returnVal =  1;
            }else if(one.getPrice() < another.getPrice()){
                returnVal =  -1;
            }else if(one.getPrice() == another.getPrice()){
                returnVal =  0;
            }
            return returnVal;

        }
    }

    public class LocSorter implements Comparator<Products> {

        public int compare(Products one, Products another){

            int returnVal = one.getLocationName().compareTo(another.getLocationName());

            return returnVal;

        }
    }


}
