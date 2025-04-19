package com.example.mvc.favproducts.controller;

import com.example.mvc.model.Product;

public interface FavOnClickListener {
    void onRemoveFromFavClick(Product product);
}