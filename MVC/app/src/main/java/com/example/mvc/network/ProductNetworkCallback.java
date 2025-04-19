package com.example.mvc.network;

import com.example.mvc.model.Product;

import java.util.List;


public interface ProductNetworkCallback {

    public void onSuccessResult(ProductResponse productResponse);
    public void onFailureResult(String error);

}