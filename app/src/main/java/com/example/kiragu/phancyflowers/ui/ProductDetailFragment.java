package com.example.kiragu.phancyflowers.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kiragu.phancyflowers.R;
import com.example.kiragu.phancyflowers.models.Product;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProductDetailFragment extends Fragment implements View.OnClickListener{
    private static final int MAX_WIDTH = 300;
    private static final int MAX_HEIGHT = 250;

    @Bind(R.id.imgview)
    ImageView mImageLabel;
    @Bind(R.id.product_name1)
    TextView mProductName1;
    @Bind(R.id.descriptionTextView)
    TextView mDescriptionLabel;
    @Bind(R.id.addToCartButton)
    TextView mAddToCart;

    private Product mProduct;

    public static ProductDetailFragment newInstance(Product product) {
        ProductDetailFragment productDetailFragment = new ProductDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("product", Parcels.wrap(product));
        productDetailFragment.setArguments(args);
        return productDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProduct = Parcels.unwrap(getArguments().getParcelable("product"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext())
                .load(mProduct.getPhoto())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(mImageLabel);

        mProductName1.setText(mProduct.getName());
        return view;
    }
    @Override
    public void onClick(View v) {
        if (v == mAddToCart) {

            Toast.makeText(getContext(), "Added To Cart", Toast.LENGTH_SHORT).show();
        }
    }
}

