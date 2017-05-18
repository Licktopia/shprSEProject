package com.jltechnologies.shopr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import static android.view.View.GONE;

public class FindRoute extends AppCompatActivity {
    TextView mAtText;
    TextView mGoToText;
    TextView mDirectionsText;
    Button nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_route);
        mAtText = (TextView)findViewById(R.id.at_text);
        mGoToText = (TextView)findViewById(R.id.goto_text);
        nextButton = (Button)findViewById(R.id.next_button);
        nextButton.setVisibility(View.VISIBLE);
        mDirectionsText = (TextView)findViewById(R.id.directions_text);
        int[] locations = new int[ShoppingCartActivity.mProductses.size()];//will store 0 if location not visited, 1 if visited
        Arrays.fill(locations,0);//fills locations array to 0
        for(int i = 0; i < ShoppingCartActivity.mProductses.size(); i++){
            if(ShoppingCartActivity.mProductses.get(i).getProudctCount()>0) {
                locations[ShoppingCartActivity.mProductses.get(i).getLocation() - 1] = i + 1;
            }
        }
        final ArrayList<Integer> locationsToVisit = new ArrayList<>();
        if (ShoppingCartActivity.leftEntrance){
            int locationNumber =  Arrays.asList(ShoppingCartActivity.mInventory.mStores[ShoppingCartActivity.storeNumber].locationNames).indexOf("Left Entrance")+1;
            locationsToVisit.add(locationNumber);
        }
        else{
            int locationNumber =  Arrays.asList(ShoppingCartActivity.mInventory.mStores[ShoppingCartActivity.storeNumber].locationNames).indexOf("Right Entrance")+1;
            locationsToVisit.add(locationNumber);
        }
        for(int i = 0; i < locations.length; i++) { //makes list of locations,
            if(locations[i]!=0){
                locationsToVisit.add(i+1);
            }

        }
        locationsToVisit.add(Arrays.asList(ShoppingCartActivity.mInventory.mStores[ShoppingCartActivity.storeNumber].locationNames).indexOf("Cashier")+1);
        final int[] counter = {0};
        setRouteText(counter[0],locationsToVisit);
        setDirectionsText(counter[0],locationsToVisit);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter[0]!=locationsToVisit.size()-1) {
                    counter[0]++;
                    setRouteText(counter[0], locationsToVisit);
                    setDirectionsText(counter[0],locationsToVisit);
                }
                else{
                    nextButton.setVisibility(GONE);
                }

            }
        });

        ///////////FUNCTION TO SORT LOCATIONS INTO BEST OPTIMAL ORDER GOES HERE, ADD MATRICES TO STORES

    }

    private void setRouteText(int count, ArrayList<Integer> locationsToVisit){
        String nextText = "Next go to ";
        String currentText = ShoppingCartActivity.mInventory.mStores[ShoppingCartActivity.storeNumber].locationNames[locationsToVisit.get(count)-1];
        mAtText.setText("You are at the " + currentText);
        if(locationsToVisit.size()>0) {
            if(count!=locationsToVisit.size()-1) {
                 nextText += ShoppingCartActivity.mInventory.mStores[ShoppingCartActivity.storeNumber].locationNames[locationsToVisit.get(count + 1) - 1];
            }
            else{
                 nextText = "Have a safe trip home";
            }
            mGoToText.setText(nextText);
        }
    }
    private void setDirectionsText(int count, ArrayList<Integer> locationsToVisit){
        String directionsText = "In this area pick up ";

        if(locationsToVisit.size()>0) {
            if(count!=locationsToVisit.size()-1) {
                if(count==0){
                    directionsText="Welcome to the store.";
                }
                else if(count ==locationsToVisit.size()-1){
                    directionsText = "You are all finished";
                }
                else {
                    for (int i = 0; i < ShoppingCartActivity.mProductses.size(); i++) {
                        if (locationsToVisit.get(count) == ShoppingCartActivity.mProductses.get(i).getLocation()) {
                            if(ShoppingCartActivity.mProductses.get(i).getProudctCount()>0) {
                                directionsText += ShoppingCartActivity.mProductses.get(i).getProudctCount() + " " +
                                        ShoppingCartActivity.mProductses.get(i).getLabel();
                            }
                        }
                    }
                }
            }
            else{
                directionsText = "You are all finished";
            }
            mDirectionsText.setText(directionsText);
        }

    }
}
