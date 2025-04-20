package com.example.mvp.favproducts.presenter;


import androidx.lifecycle.LiveData;

import com.example.mvp.model.Pojo.Product;

import java.util.List;

public interface IFavPresenter {
    LiveData<List<Product>> getLocalData();
    void remopveFromFav(Product product);
}
