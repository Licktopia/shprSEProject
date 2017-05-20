package com.jltechnologies.shopr;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;


import java.text.DecimalFormat;
import java.util.ArrayList;

public class ShoppingCartActivity extends AppCompatActivity {
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        ListView list = (ListView) findViewById(android.R.id.list);//list is scrolling view that is dynamically populated
        /////////bindings
        mTotal = (TextView)findViewById(R.id.total_amount);
        mFindRoute = (Button)findViewById(R.id.find_route); //initialize find route button
        mStoreTitle = (TextView) findViewById(R.id.store_title); //initialize find route button

        mSharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);//shared preferences saves variable states for when the app is paused or looses focus
        mEditor = mSharedPreferences.edit();
        backout = false;
        mInventory = new Stores();//create inventory object that gives us access to store products, prices and product locations


        storeNumber = getIntent().getExtras().getInt("storeNumber"); //gets Store Number from start screen activity


        mStoreTitle.setText(mInventory.mStores[storeNumber].storeName + " Shopping List");//set text for top of screen title  ie "Juliaville Shopping List"


        int products = 0;
        System.out.println(mInventory.mStores[storeNumber].products.length);
        for (int i = 0; i < mInventory.mStores[storeNumber].products.length; i++){////retrieve saved data from shared preferences
            products = mSharedPreferences.getInt(KEY_STROKECOUNT + i, 0);
            mProductses.add(new Products(mInventory.mStores[storeNumber].products[i] + "\n", products,
                    mInventory.mStores[storeNumber].prices[i], mInventory.mStores[storeNumber].location[i]));
        }

        mListAdapter = new ListAdapter(this, mProductses);////list adapter is adapter class that binds info to the list view
        list.setAdapter(mListAdapter);

        updateTotal();//display $$$ Total

        mFindRoute.setOnClickListener(new View.OnClickListener() {//click listener for Find Route Button
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingCartActivity.this, FindRouteActivity.class);//state intent to go to Find Route class
                startActivity(intent);//GO
            }
        });
    }

    @Override
    protected void onPause() {//on pause save shopping list
        super.onPause();
        if(!backout) {
            for (int i = 0; i < mInventory.mStores[storeNumber].products.length; i++) {
                mEditor.putInt(KEY_STROKECOUNT + i, mProductses.get(i).getProudctCount());
            }
        }
        mEditor.apply();
    }

    public static void updateTotal(){//function iterates through shopping list and sets and displays total amount $$$
        double total = 0.0;
        for(int i = 0; i< mInventory.mStores[storeNumber].products.length; i++){
            total += mProductses.get(i).getProudctCount()*mProductses.get(i).getPrice();
        }
        DecimalFormat df = new DecimalFormat("#.##");
        total = Double.valueOf(df.format(total));
        mTotal.setText("$"+total);

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
                products.setProudctCount(0);
            }
            mListAdapter.notifyDataSetChanged();//updates List Adapter when clear cart clicked, otherwise data changed but view not refreshed
            updateTotal();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        backout = true;
        mProductses.clear();
        mListAdapter.notifyDataSetChanged();
        mEditor.clear();
        mEditor.apply();


        Intent intent = new Intent(ShoppingCartActivity.this, StartScreenActivity.class);//state intent to go to Find Route class
        startActivity(intent);//GO
    }
}
