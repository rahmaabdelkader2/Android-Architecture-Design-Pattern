package com.example.mvp.model.Local;


import androidx.lifecycle.LiveData;

import com.example.mvp.model.Pojo.Product;

import java.util.List;

public interface IProductLocalDataSource {
    void insertProduct(Product product);
    void deleteProduct(Product product);
    LiveData<List<Product>> getAllProducts();
}