package com.jltechnologies.shopr;

import org.junit.Test;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Omeed on 6/4/17.
 */
public class ListAdapterTest {
    Context mContext;

    @Test
    public void getCount() throws Exception {
        ArrayList<Products> mProductses = new ArrayList<>();
        Stores mInventory = new Stores();
        for (int i = 0; i < mInventory.mStores[0].products.length; i++) {////retrieve saved data from shared preferences
            mProductses.add(new Products(mInventory.mStores[0].products[i], 0,
                    mInventory.mStores[0].prices[i], mInventory.mStores[0].location[i],
                    mInventory.mStores[0].picTags[i],mInventory.mStores[0].locationNames[mInventory.mStores[0].location[i]-1]));
        }
        ListAdapter mListAdapter = new ListAdapter(mContext, mProductses);
        assertEquals(13,mListAdapter.getCount());
    }

    @Test
    public void getItem() throws Exception {
        ArrayList<Products> mProductses = new ArrayList<>();
        Stores mInventory = new Stores();
        Random random = new Random();
        for (int i = 0; i < mInventory.mStores[0].products.length; i++) {////retrieve saved data from shared preferences
            mProductses.add(new Products(mInventory.mStores[0].products[i], 3,
                    mInventory.mStores[0].prices[i], mInventory.mStores[0].location[i],
                    mInventory.mStores[0].picTags[i],mInventory.mStores[0].locationNames[mInventory.mStores[0].location[i]-1]));
        }
        ListAdapter mListAdapter = new ListAdapter(mContext, mProductses);
        //int element = random.nextInt(mInventory.mStores[0].products.length);
        Products item = (Products) mListAdapter.getItem(0);
        assertFalse(item == null);
        assertEquals("Eggs", item.getLabel());
        assertEquals(3, item.getProductCount());
        assertEquals(1.99, item.getPrice(), 0);
        assertEquals(6, item.getLocation());
        assertEquals(R.drawable.eggs, item.getPicture());
        assertEquals("Aisle 2", item.getLocationName());

    }

    @Test
    public void getItemId() throws Exception {
        ArrayList<Products> mProductses = new ArrayList<>();
        Stores mInventory = new Stores();
        Random random = new Random();
        for (int i = 0; i < mInventory.mStores[0].products.length; i++) {////retrieve saved data from shared preferences
            mProductses.add(new Products(mInventory.mStores[0].products[i], 3,
                    mInventory.mStores[0].prices[i], mInventory.mStores[0].location[i],
                    mInventory.mStores[0].picTags[i],mInventory.mStores[0].locationNames[mInventory.mStores[0].location[i]-1]));
        }
        ListAdapter mListAdapter = new ListAdapter(mContext, mProductses);
        for (int i = 0; i < mInventory.mStores[0].products.length; i++)
            assertEquals(0, mListAdapter.getItemId(i));
    }

    @Test
    public void getView() throws Exception {
        /*
        NOTE: Not a complete unit test! No assert statements yet.
        */
        ArrayList<Products> mProductses = new ArrayList<>();
        Stores mInventory = new Stores();
        Random random = new Random();
        for (int i = 0; i < mInventory.mStores[0].products.length; i++) {////retrieve saved data from shared preferences
            mProductses.add(new Products(mInventory.mStores[0].products[i], 3,
                    mInventory.mStores[0].prices[i], mInventory.mStores[0].location[i],
                    mInventory.mStores[0].picTags[i],mInventory.mStores[0].locationNames[mInventory.mStores[0].location[i]-1]));
        }
        ListAdapter mListAdapter = new ListAdapter(mContext, mProductses);
    }

}