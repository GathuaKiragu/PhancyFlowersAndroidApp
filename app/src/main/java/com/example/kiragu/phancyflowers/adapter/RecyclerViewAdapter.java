package com.example.kiragu.phancyflowers.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kiragu.phancyflowers.R;

/**
 * Created by kiragu on 6/21/17.
 */

public class RecyclerViewAdapter {
    private List<ItemObjects> itemList;
    private Context context;

    public SolventRecyclerViewAdapter(Context context, List<ItemObjects> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public SolventViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.products, null);
        SolventViewHolders rcv = new SolventViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(SolventViewHolders holder, int position) {
        holder.countryName.setText(itemList.get(position).getName());
        holder.countryPhoto.setImageResource(itemList.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
