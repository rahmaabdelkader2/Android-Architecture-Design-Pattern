package com.example.mvp.allprodcts.presenter;

import com.example.mvp.model.Pojo.Product;

public interface Ipresenter {
    void getAllProducts();

    void addToFavProducts(Product product);
}
