package com.example.kiragu.phancyflowers.adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kiragu.phancyflowers.R;
import com.example.kiragu.phancyflowers.models.Product;

import java.util.List;

/**
 * Created by kiragu on 6/21/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<ProductsViewHolder>  {
    private List<Product> itemList;
    private Context context;

    public RecyclerViewAdapter(Context context, List<Product> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public ProductsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.products, null);
        ProductsViewHolder rcv = new ProductsViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(ProductsViewHolder holder, int position) {
        holder.productName.setText(itemList.get(position).getName());
        holder.productPhoto.setImageResource(itemList.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}