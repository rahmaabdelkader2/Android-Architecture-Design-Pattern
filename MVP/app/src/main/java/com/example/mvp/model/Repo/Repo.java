package com.example.mvp.model.Repo;

import androidx.lifecycle.LiveData;

import com.example.mvp.model.Local.IProductLocalDataSource;
import com.example.mvp.model.Pojo.Product;
import com.example.mvp.model.Remote.IProductRemoteDataSource;
import com.example.mvp.model.Remote.NetworkCallback;

import java.util.List;

public class Repo implements IRepo {
    private final IProductLocalDataSource localDataSource;
    private final IProductRemoteDataSource remoteDataSource;

    private static IRepo instance = null;

    private Repo(IProductLocalDataSource localDataSource,
                       IProductRemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    public static synchronized IRepo getInstance(IProductLocalDataSource localDataSource,
                                                       IProductRemoteDataSource remoteDataSource) {
        if (instance == null) {
            instance = new Repo(localDataSource, remoteDataSource);
        }
        return instance;
    }

    @Override
    public LiveData<List<Product>> getStoredProducts() {
        return localDataSource.getAllProducts();
    }
    @Override
    public void getAllProductsFromRemoteSource(NetworkCallback callback){
        remoteDataSource.makeNetworkCall(callback);
    }

    @Override
    public void insertProduct(Product product) {
        localDataSource.insertProduct(product);
    }

    @Override
    public void deleteProduct(Product product) {
        localDataSource.deleteProduct(product);
    }
}