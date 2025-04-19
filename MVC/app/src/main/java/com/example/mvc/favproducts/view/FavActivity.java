package com.example.mvc.favproducts.view;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mvc.R;
import com.example.mvc.favproducts.controller.FavAdapter;
import com.example.mvc.favproducts.controller.FavOnClickListener;
import com.example.mvc.model.Product;
import com.example.mvc.model.Repo;
import java.util.List;

public class FavActivity extends AppCompatActivity implements FavOnClickListener {

    private RecyclerView recyclerView;
    private FavAdapter adapter;
    private Repo repo;

    private Button backButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);

        repo = Repo.getInstance(this);

        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FavAdapter(this);
        recyclerView.setAdapter(adapter);

        repo.getAll_products().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                adapter.setProducts(products);
            }
        });


        backButton2=findViewById(R.id.backButton2);
        backButton2.setOnClickListener(v -> finish());
    }

    @Override
    public void onRemoveFromFavClick(Product product) {
        repo.delete(product);
    }
}