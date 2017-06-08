package com.jltechnologies.shopr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class StartScreenActivity extends AppCompatActivity {
    private static final String PREFS_FILE2 = "com.jltechnologies.shopr.preferences";
    private static final String STORE_NUMBER = "storenumber";
    private int[] storeTags = {R.id.store1,R.id.store2,R.id.store3,R.id.store4,R.id.store5, R.id.store6};//array that holds the ids of the store text views
    public int storeNumber;
    Button nextButton;
    SharedPreferences sp;
    public static SharedPreferences.Editor ed;

    int[] RbTags = {R.id.default_radio1,R.id.default_radio2,R.id.default_radio3,R.id.default_radio4,R.id.default_radio5,R.id.default_radio6};






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        nextButton = (Button)findViewById(R.id.next_button);

        final boolean clearOut = true;
        sp = getSharedPreferences(PREFS_FILE2, Context.MODE_PRIVATE);//shared preferences saves variable states for when the app is paused or looses focus
        ed = sp.edit();
        storeNumber = sp.getInt(STORE_NUMBER, 0);
        for(int i = 0; i <RbTags.length; i++){
            RadioButton rb = (RadioButton)findViewById(RbTags[i]);
            if(i==storeNumber){
                rb.setChecked(true);
            }
            else{
                rb.setChecked(false);
            }
        }

            nextButton.setOnClickListener(new View.OnClickListener() {//set click listener for each store button
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(StartScreenActivity.this, ShoppingCartActivity.class);//state intent to go to Shopping Cart Activity
                   intent.putExtra("storeNumber", storeNumber);//pass store number selected to SC Activity
                   intent.putExtra("clearCart", clearOut);
                   startActivity(intent);//GO
               }
           });


    }

    @Override
    protected void onPause() {//on pause save shopping list
        super.onPause();


                ed.putInt(STORE_NUMBER, storeNumber);


        ed.apply();
    }

    @Override
    protected void onResume() {//on pause save shopping list
        super.onResume();


        storeNumber = sp.getInt(STORE_NUMBER, 0);
        for(int i = 0; i <RbTags.length; i++){
            RadioButton rb = (RadioButton)findViewById(RbTags[i]);
            if(i==storeNumber){
                rb.setChecked(true);
            }
            else{
                rb.setChecked(false);
            }
        }
    }


    public void onRadioButtonClicked(View view) {//Select Left or Right Entrance
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.default_radio1:
                if (checked) {
                    storeNumber = 0;
                    break;
                }
            case R.id.default_radio2:
                if (checked) {
                    storeNumber = 1;
                    break;
                }
            case R.id.default_radio3:
                if (checked) {
                    storeNumber = 2;
                    break;
                }
            case R.id.default_radio4:
                if (checked) {
                    storeNumber = 3;
                    break;
                }
            case R.id.default_radio5:
                if (checked) {
                    storeNumber = 4;
                    break;
                }
            case R.id.default_radio6:
                if (checked) {
                    storeNumber = 5;
                    break;
                }
        }
    }
}
