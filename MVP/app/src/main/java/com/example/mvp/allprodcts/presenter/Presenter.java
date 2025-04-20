package com.example.mvp.allprodcts.presenter;
import com.example.mvp.allprodcts.view.IView;

import com.example.mvp.model.Pojo.Product;
import com.example.mvp.model.Remote.NetworkCallback;
import com.example.mvp.model.Repo.IRepo;

import java.util.List;

public class Presenter implements Ipresenter, NetworkCallback {
    IRepo repository;
    IView view;
    public Presenter(IView view, IRepo repo) {
        this.view = view;
        this.repository = repo;
    }
    @Override
    public void getAllProducts() {
        repository.getAllProductsFromRemoteSource(this);
    }
    @Override
    public void addToFavProducts(Product product) {
        repository.insertProduct(product);
    }

    @Override
    public void onSuccess(List<Product> Products) {
        view.showData(Products);
    }

    @Override
    public void onFailure(String errorMessage) {
        view.showError(errorMessage);
    }
}
