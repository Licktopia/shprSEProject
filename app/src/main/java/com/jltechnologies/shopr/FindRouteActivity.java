package com.jltechnologies.shopr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import static android.view.View.GONE;

public class FindRouteActivity extends AppCompatActivity {
    TextView mAtText; //Current location text display
    TextView mGoToText; //Next location text display
    TextView mDirectionsText; //Instructions text display
    Button nextButton; //Next Button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_route);
        ////////Bindings
        mAtText = (TextView)findViewById(R.id.at_text);
        mGoToText = (TextView)findViewById(R.id.goto_text);
        nextButton = (Button)findViewById(R.id.next_button);
        nextButton.setVisibility(View.VISIBLE);
        mDirectionsText = (TextView)findViewById(R.id.directions_text);
        //////End Bindings

        int[] locations = new int[ShoppingCartActivity.mProductses.size()];//will store 0 if location not visited, location number if visited
        Arrays.fill(locations,0);//fills locations array to 0
        for(int i = 0; i < ShoppingCartActivity.mProductses.size(); i++){
            if(ShoppingCartActivity.mProductses.get(i).getProudctCount()>0) {
                locations[ShoppingCartActivity.mProductses.get(i).getLocation() - 1] = i + 1;//ie locations[3] = 3
            }
        }
        final ArrayList<Integer> locationsToVisit = new ArrayList<>();//dyn array that will store a list of locations to visit, weeding out locations that are not visited

        if (ShoppingCartActivity.leftEntrance){//add left or right entrance to 1rst spot in locations to visit dynarray
            int locationNumber =  Arrays.asList(ShoppingCartActivity.mInventory.mStores[ShoppingCartActivity.storeNumber].locationNames).indexOf("The Left Entrance")+1;
            locationsToVisit.add(locationNumber);
        }
        else{//add left or right entrance to 1rst spot in locations to visit dynarray
            int locationNumber =  Arrays.asList(ShoppingCartActivity.mInventory.mStores[ShoppingCartActivity.storeNumber].locationNames).indexOf("The Right Entrance")+1;
            locationsToVisit.add(locationNumber);
        }
        for(int i = 0; i < locations.length; i++) { //adds locations to locations to visit dynarray
            if(locations[i]!=0){
                locationsToVisit.add(i+1);
            }

        }
        locationsToVisit.add(Arrays.asList(ShoppingCartActivity.mInventory.mStores[ShoppingCartActivity.storeNumber].locationNames).indexOf("The Cashier")+1);//add cashier to end of locations to visit
        final int[] counter = {0};
        setRouteText(counter[0],locationsToVisit);
        setDirectionsText(counter[0],locationsToVisit);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//click listener for Next Button
                if(counter[0]!=locationsToVisit.size()- 2&&counter[0]!=locationsToVisit.size()-1) {
                    counter[0]++;
                    setRouteText(counter[0], locationsToVisit);
                    setDirectionsText(counter[0],locationsToVisit);
                }
                else if(counter[0]==locationsToVisit.size()-2){
                    counter[0]++;
                    nextButton.setText("Done");
                    setRouteText(counter[0], locationsToVisit);
                    setDirectionsText(counter[0],locationsToVisit);
                }
                else{
                    Intent intent = new Intent(FindRouteActivity.this, StartScreenActivity.class);//state intent to go to Find Route class
                    startActivity(intent);//GO
                }

            }
        });

        ///////////FUNCTION TO SORT LOCATIONS INTO BEST OPTIMAL ORDER GOES HERE, ADD MATRICES TO STORES

    }

    private void setRouteText(int count, ArrayList<Integer> locationsToVisit){//function puts text for the current location and next location such as "Now at Aisle 1" and "Go to Bakery"
        StringBuilder nextText = new StringBuilder();
        nextText.append("Next go to ");
        //String nextText = "Next go to ";
        StringBuilder currentText = new StringBuilder();
        //String currentText = ShoppingCartActivity.mInventory.mStores[ShoppingCartActivity.storeNumber].locationNames[locationsToVisit.get(count)-1];
         currentText.append(ShoppingCartActivity.mInventory.mStores[ShoppingCartActivity.storeNumber].locationNames[locationsToVisit.get(count)-1]);
        mAtText.setText("You are at " + currentText);
        if(locationsToVisit.size()>0) {
            if(count!=locationsToVisit.size()-1) {
                 nextText.append(ShoppingCartActivity.mInventory.mStores[ShoppingCartActivity.storeNumber].locationNames[locationsToVisit.get(count + 1) - 1]);
            }
            else{
                 nextText.setLength(0);
                 nextText.append("Have a safe trip home");
            }
            mGoToText.setText(nextText);
        }
    }
    private void setDirectionsText(int count, ArrayList<Integer> locationsToVisit){//function sets text such as "pick up 1 Tylenol" for current location
        StringBuilder directionsText = new StringBuilder();
        directionsText.append("In this area pick up ");

        if(count == locationsToVisit.size()-1) {
            directionsText.setLength(0);
            directionsText.append("You are all finished");
        }



        ArrayList<Products> mThisLocation = new ArrayList<>();
        if(locationsToVisit.size()>0) {
            if(count!=locationsToVisit.size()-1) {
                if(count==0){
                    directionsText.setLength(0);
                    directionsText.append("Welcome to the store.");
                }

                else {
                    for (int i = 0; i < ShoppingCartActivity.mProductses.size(); i++)
                        if (locationsToVisit.get(count) == ShoppingCartActivity.mProductses.get(i).getLocation()) {
                            if (ShoppingCartActivity.mProductses.get(i).getProudctCount() > 0) {
                                mThisLocation.add(ShoppingCartActivity.mProductses.get(i));
                            }
                        }
                    for (int j = 0; j < mThisLocation.size(); j++){
                                directionsText.append(mThisLocation.get(j).getProudctCount());
                                directionsText.append(" ");
                                directionsText.append(mThisLocation.get(j).getLabel());
                                //directionsText.delete(directionsText.length()-1, directionsText.length());
                                directionsText.setLength(directionsText.length());
                                if(mThisLocation.size()>1) {
                                    if(j<mThisLocation.size()-2) {
                                        directionsText.append(",");
                                        directionsText.append(" ");
                                    }
                                    else if(j==mThisLocation.size()-2){
                                        directionsText.append(",");
                                        directionsText.append(" and ");
                                    }
                                }
                            }

                    }
                }
            }
            else{
                 directionsText.setLength(0);
                 directionsText.append("You are all finished");
            }
            mDirectionsText.setText(directionsText);
        }

    }

