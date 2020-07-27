package com.afi.latihan.retrofitgson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class ApiConfig {

    static ApiService getApiService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiService.class);
    }
}
