package com.example.kiragu.phancyflowers.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kiragu.phancyflowers.R;

/**
 * Created by kiragu on 6/21/17.
 */

public class ProductsViewHolder {
    public TextView countryName;
    public ImageView countryPhoto;

    public ProductsViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        countryName = (TextView) itemView.findViewById(R.id.product_name);
        countryPhoto = (ImageView) itemView.findViewById(R.id.product_photo);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Position = " + getPosition(), Toast.LENGTH_SHORT).show();
    }
}
