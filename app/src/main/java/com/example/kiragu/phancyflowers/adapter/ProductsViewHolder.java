package com.example.kiragu.phancyflowers.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kiragu.phancyflowers.R;
import com.example.kiragu.phancyflowers.models.Product;
import com.example.kiragu.phancyflowers.ui.LoginActivity;
import com.example.kiragu.phancyflowers.ui.ProductDetailActivity;
import com.example.kiragu.phancyflowers.ui.ProductDetailFragment;
import com.example.kiragu.phancyflowers.ui.ProductListActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

/**
 * Created by kiragu on 6/21/17.
 */

public class ProductsViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView productName;
    public ImageView productPhoto;

    private ArrayList<Product> mProducts = new ArrayList<>();
    private Context mContext;

    public ProductsViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        productName = (TextView) itemView.findViewById(R.id.product_name);
        productPhoto = (ImageView) itemView.findViewById(R.id.product_photo);
    }

    @Override
    public void onClick(View view) {
    }
}
