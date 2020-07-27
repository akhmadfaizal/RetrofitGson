package com.afi.latihan.retrofitgson;

import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainViewModel extends ViewModel {
    private MutableLiveData<ArrayList<User>> listUsers = new MutableLiveData<>();
    ArrayList<User> listItems = new ArrayList<>();

    private void getUser(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);

//        Call<List<ResponseUser>> client = service.getListUsers("1");

//        client.enqueue(new Callback<ResponseUser>() {
//            @Override
//            public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
//                // Jika berhasil
//                if (response.isSuccessful()){
//                    assert response.body() != null;
//                    List<User> dataArray = response.body().getData();
//                    listItems.addAll(dataArray);
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponseUser> call, Throwable t) {
//                // Jika gagal
//                t.printStackTrace();
//            }
//        });

    }

    public LiveData<ArrayList<User>> getUsers(){
        return listUsers;
    }

}
