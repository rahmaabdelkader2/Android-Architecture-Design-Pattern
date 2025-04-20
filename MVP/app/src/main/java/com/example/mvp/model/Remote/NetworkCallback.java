package com.example.mvp.model.Remote;


import com.example.mvp.model.Pojo.Product;

import java.util.List;

public interface NetworkCallback {
    public void onSuccess(List<Product> Products);
    public void onFailure(String errorMessage);
}