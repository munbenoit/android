package com.example.crypto;

import android.util.Log;

import androidx.lifecycle.ViewModel;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoinViewModel extends ViewModel {

    private final String url = "https://api.coinranking.com";
    private ApiResponse coins;
    private HttpService service;
    public CoinViewModel(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        service = retrofit.create(HttpService.class);
    }

    public void getCoinsAsync(CallbackRequestFinished callback){
        if(coins==null){
            loadData(callback);
        }
        else{
            callback.onFinished(coins);
        }


    }

    public void loadData(CallbackRequestFinished callback){


        Call<ApiResponse> coinsCall = service.getCoins();
        coinsCall.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if(response.isSuccessful()){

                    coins = response.body();
                    callback.onFinished(coins);
                }

            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }

}
