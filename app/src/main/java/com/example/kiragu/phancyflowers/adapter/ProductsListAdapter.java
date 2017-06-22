package com.example.kiragu.phancyflowers.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kiragu.phancyflowers.R;
import com.example.kiragu.phancyflowers.models.Product;
import com.example.kiragu.phancyflowers.ui.ProductDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by kiragu on 6/21/17.
 */
public class ProductsListAdapter extends RecyclerView.Adapter<ProductsListAdapter.ProductsViewHolder> {
        private ArrayList<Product> mProducts = new ArrayList<>();
        private Context mContext;

        public ProductsListAdapter(Context context, ArrayList<Product> restaurants) {
            mContext = context;
            mProducts = restaurants;
        }

        @Override
        public ProductsListAdapter.ProductsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_product_list, parent, false);
            ProductsViewHolder viewHolder = new ProductsViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ProductsListAdapter.ProductsViewHolder holder, int position) {
            holder.bindProduct(mProducts.get(position));
        }

        @Override
        public int getItemCount() {
            return mProducts.size();
        }

        public class ProductsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            @Bind(R.id.product_photo) ImageView mProductImage;
            @Bind(R.id.product_name) TextView mNameTextView;

            private Context mContext;

            public ProductsViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);

                mContext = itemView.getContext();
                itemView.setOnClickListener(this);
            }

            public void bindProduct(Product product) {
                Picasso.with(mContext).load(product.getPhoto()).into(mProductImage);
                mNameTextView.setText(product.getName());
            }

            @Override
            public void onClick(View v) {
                Log.d("click listener", "working!");
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, ProductDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("restaurants", Parcels.wrap(mProducts));
                mContext.startActivity(intent);
            }
        }
}