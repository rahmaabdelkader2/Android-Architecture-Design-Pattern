package com.example.mvp.model.Repo;

import androidx.lifecycle.LiveData;

import com.example.mvp.model.Pojo.Product;
import com.example.mvp.model.Remote.NetworkCallback;

import java.util.List;

public interface IRepo {
    LiveData<List<Product>> getStoredProducts();

    void insertProduct(Product product);

    void getAllProductsFromRemoteSource(NetworkCallback callback);
    void deleteProduct(Product product);
}