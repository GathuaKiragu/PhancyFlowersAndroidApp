package com.example.kiragu.phancyflowers.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.example.kiragu.phancyflowers.R;
import com.example.kiragu.phancyflowers.adapter.RecyclerViewAdapter;
import com.example.kiragu.phancyflowers.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {


    private StaggeredGridLayoutManager gaggeredGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        gaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        recyclerView.setLayoutManager(gaggeredGridLayoutManager);

        List<Product> gaggeredList = getListItemData();

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(ProductListActivity.this, gaggeredList);
        recyclerView.setAdapter(rcAdapter);
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    private List<Product> getListItemData(){
        List<Product> listViewItems = new ArrayList<Product>();
        listViewItems.add(new Product("Roses", R.drawable.back));
        listViewItems.add(new Product("Garden Flowers", R.drawable.example));
        listViewItems.add(new Product("Roses", R.drawable.back));
        listViewItems.add(new Product("Garden Flowers", R.drawable.back));
        listViewItems.add(new Product("Roses", R.drawable.back));
        listViewItems.add(new Product("Roses", R.drawable.example));
        listViewItems.add(new Product("Garden Flowers", R.drawable.back));
        listViewItems.add(new Product("Roses", R.drawable.back));
        listViewItems.add(new Product("Garden Flowers", R.drawable.example));
        listViewItems.add(new Product("Roses", R.drawable.example));
        listViewItems.add(new Product("Roses", R.drawable.example));
        listViewItems.add(new Product("Garden Flowers", R.drawable.example));
        return listViewItems;
    }
}
