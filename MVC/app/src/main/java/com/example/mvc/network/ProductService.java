package com.example.mvc.network;


import retrofit2.http.GET;
import retrofit2.Call; // Add this import
public interface ProductService {
    @GET("products")
    Call<ProductResponse> getProducts();
}
