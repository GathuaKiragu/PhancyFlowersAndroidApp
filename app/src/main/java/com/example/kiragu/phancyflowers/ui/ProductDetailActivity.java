package com.example.kiragu.phancyflowers.ui;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.kiragu.phancyflowers.R;
import com.example.kiragu.phancyflowers.adapter.ProductPagerAdapter;
import com.example.kiragu.phancyflowers.models.Product;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProductDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager)
    ViewPager mViewPager;
    private ProductPagerAdapter adapterViewPager;
    ArrayList<Product> mProducts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ButterKnife.bind(this);

        mProducts = Parcels.unwrap(getIntent().getParcelableExtra("products"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new ProductPagerAdapter(getSupportFragmentManager(), mProducts);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}