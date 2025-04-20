package com.example.mvp.allprodcts.view;

import com.example.mvp.model.Pojo.Product;

import java.util.List;

public interface IView {
    void showData(List<Product> products);
    void showError(String errorMessage);
}
