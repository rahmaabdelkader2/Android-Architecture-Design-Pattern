package com.example.mvc.network;

import android.net.ConnectivityManager;

import com.example.mvc.model.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductClient {

    private static final String BASE_URL ="https://dummyjson.com/" ;
    private ProductService service ;
    private ProductResponse products = null ;
    public ProductClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service =retrofit.create(ProductService.class);
    }


    public void makeNetworkCall(ProductNetworkCallback callBack) {

        Call<ProductResponse> call = service.getProducts();
        call.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                if(response.isSuccessful())
                {
                    callBack.onSuccessResult(response.body());
                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                callBack.onFailureResult(t.getMessage());
                t.printStackTrace();
            }
        });

    }


}