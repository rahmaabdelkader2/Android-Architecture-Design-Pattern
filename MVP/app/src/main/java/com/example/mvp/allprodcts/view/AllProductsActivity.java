package com.example.mvp.allprodcts.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mvp.allprodcts.presenter.Presenter;
import com.example.mvp.model.Pojo.Product;
import com.example.mvp.model.Repo.Repo;
import com.example.mvp.R;
import com.example.mvp.model.Local.ProductLocalDataSource;
import com.example.mvp.model.Remote.ProductRemoteDataSource;

import java.util.List;

public class AllProductsActivity extends AppCompatActivity implements IView,OnProductClickListener{

    RecyclerView recyclerView;
    Adapter adapter;
    Presenter presenter;
    LinearLayoutManager layoutManager;

    Button backbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allproducts);
        recyclerView= findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        presenter = new Presenter(this, Repo.getInstance(ProductLocalDataSource.getInstance(this), ProductRemoteDataSource.getInstance()));
        presenter.getAllProducts();

        backbtn=findViewById(R.id.backButton);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    @Override
    public void showData(List<Product> products) {
        adapter = new Adapter(products,this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnAddToFavClick(Product product) {
        presenter.addToFavProducts(product);
        Toast.makeText(this, "Item Added to fav", Toast.LENGTH_SHORT).show();
    }

}
