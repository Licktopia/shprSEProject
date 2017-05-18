package com.jltechnologies.shopr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jeff on 12/14/16.
 */

public class ListAdapter extends BaseAdapter{
    private final Context mContext;
    private final ArrayList<Products> mProductses;


    public ListAdapter(Context context, ArrayList<Products> productses){
        mContext = context;
        mProductses = productses;
    }
    @Override
    public int getCount() {
        return mProductses.size();
    }

    @Override
    public Object getItem(int i) {
        return mProductses.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup viewGroup) {

        final ViewHolder holder;

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item,null);
            holder = new ViewHolder();
            holder.holeLabel = (TextView) convertView.findViewById(R.id.holeLabel);
            holder.strokeCount = (TextView) convertView.findViewById(R.id.strokeCount);
            holder.removeStrokeButton = (Button) convertView.findViewById(R.id.removeStrokeButton);
            holder.addStrokeButton = (Button) convertView.findViewById(R.id.addStrokeButton);
            holder.addPrice = (TextView) convertView.findViewById(R.id.priceDisplay);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.holeLabel.setText(mProductses.get(i).getLabel());
        holder.strokeCount.setText(mProductses.get(i).getStrokeCount() + "");
        holder.addPrice.setText("$"+mProductses.get(i).getPrice()+"");
        holder.removeStrokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int updateStrokeCount = mProductses.get(i).getStrokeCount()-1;
                if(updateStrokeCount < 0) {
                    updateStrokeCount = 0;
                }
                mProductses.get(i).setStrokeCount(updateStrokeCount);
                holder.strokeCount.setText(updateStrokeCount + "");
                MainActivity.updateTotal();
            }
        });
        holder.addStrokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int updateStrokeCount = mProductses.get(i).getStrokeCount()+1;
                mProductses.get(i).setStrokeCount(updateStrokeCount);
                holder.strokeCount.setText(updateStrokeCount + "");
                MainActivity.updateTotal();
            }
        });
        return convertView;
    }

    private static class ViewHolder {
        TextView holeLabel;
        TextView strokeCount;
        Button removeStrokeButton;
        Button addStrokeButton;
        TextView addPrice;
    }
}
