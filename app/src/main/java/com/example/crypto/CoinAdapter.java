package com.example.crypto;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class CoinAdapter extends RecyclerView.Adapter<CoinAdapter.MyViewHolder> {


    private ApiResponse coins;
    private onItemClickCallback callback;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.line_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TextView symbol = holder.line.findViewById(R.id.list_item_symbol);
        TextView value = holder.line.findViewById(R.id.list_item_value);
        symbol.setText(coins.getData().getCoins().get(position).getSymbol());
        value.setText(coins.getData().getCoins().get(position).getPrice());


        LinearLayout cell = holder.line.findViewById(R.id.cell);
        symbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return coins.getData().getCoins().size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        LinearLayout line;

        public MyViewHolder(LinearLayout v){
            super(v);
            line = v;
        }

    }

    public CoinAdapter(onItemClickCallback callback, ApiResponse coins){
        this.coins = coins;
        this.callback = callback;
    }



}
