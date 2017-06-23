package com.example.kiragu.phancyflowers.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kiragu.phancyflowers.R;

import java.util.ArrayList;

/**
 * Created by kiragu on 6/21/17.
 */

public class ProductsListAdapter extends RecyclerView.Adapter<ProductsListAdapter.ViewHolder> {
    private ArrayList<AndroidVersion> arrayList;
    private Context mcontext;

    public ProductsListAdapter(Context context, ArrayList<AndroidVersion> android) {
        this.arrayList = android;
        this.mcontext = context;
    }

    @Override
    public void onBindViewHolder(ProductsListAdapter.ViewHolder holder, int i) {

        holder.textView.setText(arrayList.get(i).getrecyclerViewTitleText());
        holder.imageView.setImageResource(arrayList.get(i).getrecyclerViewImage());
    }

    @Override
    public ProductsListAdapter.ViewHolder onCreateViewHolder(ViewGroup vGroup, int i) {

        View view = LayoutInflater.from(vGroup.getContext()).inflate(R.layout.product_layout, vGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        private ImageView imageView;

        public ViewHolder(View v) {
            super(v);

            textView = (TextView) v.findViewById(R.id.text);
            imageView = (ImageView) v.findViewById(R.id.image);
        }
    }
}