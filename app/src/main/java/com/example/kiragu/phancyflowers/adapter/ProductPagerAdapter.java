package com.example.kiragu.phancyflowers.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.kiragu.phancyflowers.models.Product;
import com.example.kiragu.phancyflowers.ui.ProductDetailFragment;

import java.util.ArrayList;


/**
 * Created by kiragu on 6/21/17.
 */

public class ProductPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Product> mProducts;

    public ProductPagerAdapter(FragmentManager fm, ArrayList<Product> products) {
        super(fm);
        mProducts = products;
    }

    @Override
    public Fragment getItem(int position) {
        return ProductDetailFragment.newInstance(mProducts.get(position));
    }

    @Override
    public int getCount() {
        return (mProducts == null) ? 0 : mProducts.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mProducts.get(position).getName();
    }
}
