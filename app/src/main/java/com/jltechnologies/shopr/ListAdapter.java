package com.jltechnologies.shopr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class ListAdapter extends BaseAdapter{//adapter class that binds list_item.xml to each product in array and populates shopping list
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
            holder.productlabel = (TextView) convertView.findViewById(R.id.holeLabel);
            holder.quantity = (TextView) convertView.findViewById(R.id.strokeCount);
            holder.removeProductButton = (Button) convertView.findViewById(R.id.removeStrokeButton);
            holder.addProductButton = (Button) convertView.findViewById(R.id.addStrokeButton);
            holder.addPrice = (TextView) convertView.findViewById(R.id.priceDisplay);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.productlabel.setText(mProductses.get(i).getLabel());
        holder.quantity.setText(mProductses.get(i).getProudctCount() + "");
        holder.addPrice.setText("$"+mProductses.get(i).getPrice()+"");
        holder.removeProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int updateStrokeCount = mProductses.get(i).getProudctCount()-1;
                if(updateStrokeCount < 0) {
                    updateStrokeCount = 0;
                }
                mProductses.get(i).setProudctCount(updateStrokeCount);
                holder.quantity.setText(updateStrokeCount + "");
                ShoppingCartActivity.updateTotal();
            }
        });
        holder.addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int updateStrokeCount = mProductses.get(i).getProudctCount()+1;
                mProductses.get(i).setProudctCount(updateStrokeCount);
                holder.quantity.setText(updateStrokeCount + "");
                ShoppingCartActivity.updateTotal();
            }
        });
        return convertView;
    }

    private static class ViewHolder {
        TextView productlabel;
        TextView quantity;
        Button removeProductButton;
        Button addProductButton;
        TextView addPrice;
    }
}
