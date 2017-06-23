package com.example.kiragu.phancyflowers.ui;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.kiragu.phancyflowers.R;
import com.example.kiragu.phancyflowers.adapter.AndroidVersion;
import com.example.kiragu.phancyflowers.adapter.ProductsListAdapter;
import com.example.kiragu.phancyflowers.adapter.RecyclerItemClickListener;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Products extends AppCompatActivity {
    private Toolbar toolbar;

    private final String recyclerViewTitleText[] = {"Blossom Flower", "Flower", "Indoor Plants", "Gift_flowers", "Potted Flowers", "Tropical Plants", "Rose Flower", "Moss", "Fern", "Potted Plants", "Tulips", "Tropical"
    };

    private final int recyclerViewImages[] = {
            R.drawable.fern, R.drawable.flowerblog, R.drawable.indoor, R.drawable.gift_flowers, R.drawable.pottedflower, R.drawable.tropical,
            R.drawable.flow, R.drawable.moss, R.drawable.fern, R.drawable.pottedflower, R.drawable.tulips, R.drawable.tropical
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
//
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Items Added To Cart", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initRecyclerViews();
    }


    private void initRecyclerViews() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<AndroidVersion> av = prepareData();
        ProductsListAdapter mAdapter = new ProductsListAdapter(getApplicationContext(), av);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int i) {
                        Intent intent = new Intent(Products.this, Orders.class);
                        intent.putExtra("item_title", recyclerViewTitleText[i]);
                        startActivity(intent);
                    }
                })
        );

    }

    private ArrayList<AndroidVersion> prepareData() {

        ArrayList<AndroidVersion> av = new ArrayList<>();
        for (int i = 0; i < recyclerViewTitleText.length; i++) {
            AndroidVersion mAndroidVersion = new AndroidVersion();
            mAndroidVersion.setAndroidVersionName(recyclerViewTitleText[i]);
            mAndroidVersion.setrecyclerViewImage(recyclerViewImages[i]);
            av.add(mAndroidVersion);
        }
        return av;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void logout() {
        FirebaseAuth.getInstance().signOut();
    }

}
