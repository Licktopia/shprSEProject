package com.jltechnologies.shopr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StartScreenActivity extends AppCompatActivity {
    private int[] storeTags = {R.id.store1,R.id.store2,R.id.store3,R.id.store4};
    private TextView[] storeButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
        storeButtons = new TextView[storeTags.length];
        for(int i=0; i < storeTags.length;i++){
           storeButtons[i] = (TextView)findViewById(storeTags[i]);
            final int finalI = i;
            storeButtons[i].setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(StartScreenActivity.this, ShoppingCartActivity.class);
                   intent.putExtra("storeNumber", finalI);
                   startActivity(intent);
               }
           });
        }

    }
}
