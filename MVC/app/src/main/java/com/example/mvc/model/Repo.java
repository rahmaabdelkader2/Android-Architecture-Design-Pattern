package com.example.mvc.model;


import android.content.Context;

import androidx.lifecycle.LiveData;


import com.example.mvc.database.DatabaseApp;
import com.example.mvc.database.ProductDao;

import java.util.List;

public class Repo {
    private Context context;
    private ProductDao productDao;
    private LiveData<List<Product>> all_products;
    private static Repo repo = null;


    private Repo(Context context) {
        this.context=context;
        DatabaseApp db =DatabaseApp.getInstance(context.getApplicationContext());
        productDao=db.productDao();
        all_products=productDao.getAllProducts();

    }

    public static Repo getInstance(Context context)
    {
        if(repo ==null){
            repo=new Repo(context);
        }
        return repo;

    }
    public LiveData<List<Product>> getAll_products() {
        return all_products;
    }

    public void insert(Product product) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                productDao.insertProduct(product);}
        }).start();

    }

    public void delete(Product product) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                productDao.deleteProduct(product);}
        }).start();
    }
}