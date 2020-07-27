package com.afi.latihan.retrofitgson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListUserAdapter listUserAdapter;

    // Url Endpoint for get data JSON
    public static String BASE_URL = "https://reqres.in/api/users?page=1";

    // get data array from model
    private ArrayList<User> list = new ArrayList<>();

    // Variable
    RecyclerView rvUser;
    ProgressBar pbLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Lookup the recyclerview in activity layout
        rvUser = findViewById(R.id.rv_user);
        // if true, to optimize size of recyclerview
        rvUser.setHasFixedSize(true);

        pbLoading = findViewById(R.id.pb_loading);

        // get data json from Retrofit
        getUser();

    }

    private void getUser() {
        Call<ResponseUser> client = ApiConfig.getApiService().getListUsers("1");

        client.enqueue(new Callback<ResponseUser>() {
            @Override
            public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
                if (response.isSuccessful()) {
                    List<User> dataArray = response.body().getData();

                    list.addAll(dataArray);

                    showRecyclerList();

                }
            }

            @Override
            public void onFailure(Call<ResponseUser> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void showRecyclerList(){
        // Set layout manager to position the items
        rvUser.setLayoutManager(new LinearLayoutManager(this));
        // Create adapter passing in the sample user data
        listUserAdapter = new ListUserAdapter(list);
        // Attach the adapter to the recyclerview to populate items
        rvUser.setAdapter(listUserAdapter);
        pbLoading.setVisibility(View.GONE);
    }
}
