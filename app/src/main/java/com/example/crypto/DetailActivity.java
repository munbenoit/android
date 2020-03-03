package com.example.crypto;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);

        Intent intent = getIntent();
        ApiResponse.Data.Coin coin = (ApiResponse.Data.Coin) intent.getSerializableExtra("data");

        TextView text = (TextView) findViewById(R.id.detail_id);
        TextView value = findViewById(R.id.detail_coin_value);
        TextView description = findViewById(R.id.detail_coin_description);
        text.setText(coin.getSymbol());
        value.setText(coin.getPrice());
        description.setText(coin.getDescription());
        Log.i("PASS",intent.getSerializableExtra("data").toString());


    }
}
