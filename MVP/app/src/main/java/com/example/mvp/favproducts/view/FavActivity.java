package com.example.mvp.favproducts.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp.R;
import com.example.mvp.favproducts.presenter.FavPresenter;
import com.example.mvp.favproducts.presenter.IFavPresenter;
import com.example.mvp.model.Local.ProductLocalDataSource;
import com.example.mvp.model.Pojo.Product;
import com.example.mvp.model.Remote.ProductRemoteDataSource;
import com.example.mvp.model.Repo.Repo;

import java.util.List;


public class FavActivity  extends AppCompatActivity implements  OnFavClickListener {
    RecyclerView recyclerView2;
    FavAdaptor adapter;
    LinearLayoutManager layoutManager;
    IFavPresenter presenter;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);
        recyclerView2 = findViewById(R.id.recyclerView2);
        layoutManager = new LinearLayoutManager(this);
        recyclerView2.setLayoutManager(layoutManager);
        presenter = new FavPresenter( Repo.getInstance(ProductLocalDataSource.getInstance(this), ProductRemoteDataSource.getInstance()));
        LiveData<List<Product>> liveData = presenter.getLocalData();
        liveData.observe(this, products -> {
            adapter = new FavAdaptor(products, this);
            recyclerView2.setAdapter(adapter);
        });

        back=findViewById(R.id.backButton2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    public void onFavRemoveClick(Product product) {
        presenter.remopveFromFav(product);
        adapter.notifyDataSetChanged();
    }
}