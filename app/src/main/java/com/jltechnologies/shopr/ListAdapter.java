package com.jltechnologies.shopr;

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


public class ListAdapter extends BaseAdapter{//adapter class that binds list_item.xml to each product in array and populates shopping list


    Context mContext;
    public ListAdapter(Context context) {
        this.mContext = context;
    }
    private ArrayList<Products> mProductses = new ArrayList<>();


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
            holder.foodPic = (ImageView)convertView.findViewById(R.id.food_pic);
            holder.department = (TextView)convertView.findViewById(R.id.department);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Drawable drawable = mContext.getResources().getDrawable(mProductses.get(i).getPicture());
        holder.foodPic.setImageDrawable(drawable);
        holder.department.setText(mProductses.get(i).getLocationName());
        holder.productlabel.setText(mProductses.get(i).getLabel());
        holder.quantity.setText(mProductses.get(i).getProductCount() + "");
        holder.addPrice.setText("$"+mProductses.get(i).getPrice()+"");
        holder.removeProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int updateStrokeCount = mProductses.get(i).getProductCount()-1;
                if(updateStrokeCount < 0) {
                    updateStrokeCount = 0;
                }
                mProductses.get(i).setProductCount(updateStrokeCount);
                holder.quantity.setText(updateStrokeCount + "");
                ShoppingCartActivity.updateTotal();
            }
        });
        holder.addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int updateStrokeCount = mProductses.get(i).getProductCount()+1;
                mProductses.get(i).setProductCount(updateStrokeCount);
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
        ImageView foodPic;
        TextView department;
    }
}
