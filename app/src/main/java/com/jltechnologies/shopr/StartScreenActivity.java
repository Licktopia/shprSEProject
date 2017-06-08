package com.jltechnologies.shopr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class StartScreenActivity extends AppCompatActivity {
    private int[] storeTags = {R.id.store1,R.id.store2,R.id.store3,R.id.store4,R.id.store5, R.id.store6};//array that holds the ids of the store text views
    private TextView[] storeButtons;//array of store text views
    public static boolean store1Default = false;
    public static boolean store2Default = false;
    public static boolean store3Default = false;
    public static boolean store4Default = false;
    public static boolean store5Default = false;
    public static boolean store6Default = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        storeButtons = new TextView[storeTags.length];//initiliaze array
        final boolean clearOut = true;
        for(int i=0; i < storeTags.length;i++){//for each store
           storeButtons[i] = (TextView)findViewById(storeTags[i]);//binding
            final int finalI = i;
            storeButtons[i].setOnClickListener(new View.OnClickListener() {//set click listener for each store button
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(StartScreenActivity.this, ShoppingCartActivity.class);//state intent to go to Shopping Cart Activity
                   intent.putExtra("storeNumber", finalI);//pass store number selected to SC Activity
                   intent.putExtra("clearCart", clearOut);
                   startActivity(intent);//GO
               }
           });
        }

    }

    public void onRadioButtonClicked(View view) {//Select Left or Right Entrance
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.default_radio1:
                if (checked) {
                    store1Default = true;
                    store2Default = false;
                    store3Default = false;
                    store4Default = false;
                    store5Default = false;
                    store6Default = false;
                    break;
                }
            case R.id.default_radio2:
                if (checked) {
                    store1Default = false;
                    store2Default = true;
                    store3Default = false;
                    store4Default = false;
                    store5Default = false;
                    store6Default = false;
                    break;
                }
            case R.id.default_radio3:
                if (checked) {
                    store1Default = false;
                    store2Default = false;
                    store3Default = true;
                    store4Default = false;
                    store5Default = false;
                    store6Default = false;
                    break;
                }
            case R.id.default_radio4:
                if (checked) {
                    store1Default = false;
                    store2Default = false;
                    store3Default = false;
                    store4Default = true;
                    store5Default = false;
                    store6Default = false;
                    break;
                }
            case R.id.default_radio5:
                if (checked) {
                    store1Default = false;
                    store2Default = false;
                    store3Default = false;
                    store4Default = false;
                    store5Default = true;
                    store6Default = false;
                    break;
                }
            case R.id.default_radio6:
                if (checked) {
                    store1Default = false;
                    store2Default = false;
                    store3Default = false;
                    store4Default = false;
                    store5Default = false;
                    store6Default = true;
                    break;
                }
        }
    }
}
