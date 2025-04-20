package com.example.mvp.model.Remote;

import com.example.mvp.model.Pojo.ProductResponse;

import retrofit2.Call;
import retrofit2.http.GET;
public interface ProductService {
    @GET("products")
    Call<ProductResponse> getProducts();
}