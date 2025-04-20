package com.example.mvp.favproducts.presenter;

import androidx.lifecycle.LiveData;

import com.example.mvp.model.Pojo.Product;
import com.example.mvp.model.Repo.IRepo;

import java.util.List;

public class FavPresenter implements IFavPresenter {

    IRepo repo;

    public FavPresenter(IRepo repo) {

        this.repo = repo;
    }

    @Override
    public LiveData<List<Product>> getLocalData() {
        return repo.getStoredProducts();
    }

    @Override
    public void remopveFromFav(Product product) {
        repo.deleteProduct(product);
    }
}