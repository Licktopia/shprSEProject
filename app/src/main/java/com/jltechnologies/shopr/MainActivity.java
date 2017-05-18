package com.jltechnologies.shopr;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static android.R.id.list;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends ListActivity {
    private static final String PREFS_FILE = "com.jltechnologies.shopr.preferences";
    private static final String KEY_STROKECOUNT = "key_strokecount";
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    public static ArrayList <Products> mProductses = new ArrayList<Products>();
    private ListAdapter mListAdapter;
    private static Inventory mInventory;
    public static TextView mTotal;
    private Button mFindRoute;
    public boolean leftEntrance = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTotal = (TextView)findViewById(R.id.total_amount);
        mSharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        mInventory = new Inventory();
        mFindRoute = (Button)findViewById(R.id.find_route);


        //Initialize holes
        int strokes = 0;
        for (int i = 0; i < mInventory.products.length; i++){
            strokes = mSharedPreferences.getInt(KEY_STROKECOUNT + i, 0);
            mProductses.add(new Products(mInventory.products[i] + " :", strokes, mInventory.prices[i], mInventory.location[i]));
        }
        mListAdapter = new ListAdapter(this, mProductses);
        setListAdapter(mListAdapter);
        updateTotal();
        mFindRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FindRoute.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        for(int i = 0; i < mInventory.products.length; i++){
            mEditor.putInt(KEY_STROKECOUNT + i, mProductses.get(i).getStrokeCount());
        }
        mEditor.apply();
    }

    public static void updateTotal(){
        double total = 0.0;
        for(int i = 0; i<mInventory.products.length;i++){
            total += mProductses.get(i).getStrokeCount()*mProductses.get(i).getPrice();
        }
        DecimalFormat df = new DecimalFormat("#.##");
        total = Double.valueOf(df.format(total));
        mTotal.setText("$"+total);

    }

    public void onRadioButtonClicked(View view) {
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
                products.setStrokeCount(0);
            }
            mListAdapter.notifyDataSetChanged();//updates List Adapter when clear strokes clicked, otherwise data changed but view not refreshed
            updateTotal();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
