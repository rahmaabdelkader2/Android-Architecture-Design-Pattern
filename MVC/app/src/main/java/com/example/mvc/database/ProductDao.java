package com.example.mvc.database;

import androidx.room.Dao;
import androidx.lifecycle.LiveData;
import androidx.room.*;

import com.example.mvc.model.Product;

import java.util.List;

@Dao
public interface ProductDao {
    @Query("SELECT * FROM products")
    LiveData<List<Product>> getAllProducts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProduct(Product product);

    @Delete
    void deleteProduct(Product product);
}

