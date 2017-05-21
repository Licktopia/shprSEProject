package com.jltechnologies.shopr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StartScreenActivity extends AppCompatActivity {
    private int[] storeTags = {R.id.store1,R.id.store2,R.id.store3,R.id.store4,R.id.store5,R.id.store6};//array that holds the ids of the store text views
    private TextView[] storeButtons;//array of store text views

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
}
