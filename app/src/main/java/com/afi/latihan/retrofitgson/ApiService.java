package com.afi.latihan.retrofitgson;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

// Endpoint : https://reqres.in/api/users?page=1
// https://reqres.in = BASE_URL
// api/users = ENDPOINT
// ?page=1 = QUERY

public interface ApiService {
    @GET("api/users")
    Call<ResponseUser> getListUsers(@Query("page") String page);
}



