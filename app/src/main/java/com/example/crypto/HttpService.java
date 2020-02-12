package com.example.crypto;


import retrofit2.Call;
import retrofit2.http.GET;

public interface HttpService {

    @GET("/v1/public/coins")
    Call<ApiResponse> getCoins();

}
