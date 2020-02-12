package com.example.crypto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rView = (RecyclerView) findViewById(R.id.recycler_view);
        rView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rView.setLayoutManager(layoutManager);



        CoinViewModel vModel = new ViewModelProvider(this).get(CoinViewModel.class);

        vModel.getCoinsAsync(new CallbackRequestFinished() {
            @Override
            public void onFinished(ApiResponse coins) {
                if(coins!= null){
                    //Log.d("ENDED",""+coins.getData().getCoins().forEach((coin)->{return coin.toString()+" "}););
                    printAll(coins);
                    CoinAdapter cAdapter = new CoinAdapter(new onItemClickCallback() {
                        @Override
                        public void onClick(int position) {
                            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                            intent.putExtra("position",position);
                            startActivity(intent);
                        }
                    },coins);
                    rView.setAdapter(cAdapter);
                    //text.setText(coins.getData().getCoins().get(0).toString());
                }


            }
        });





    }
    protected void printAll(ApiResponse coins){
        for(ApiResponse.Data.Coin coin : coins.getData().getCoins()){
            Log.d(coin.toString(), coin.toString());
        }
    }
}
