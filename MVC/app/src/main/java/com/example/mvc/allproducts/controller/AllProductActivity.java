package com.example.mvc.allproducts.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mvc.R;
import com.example.mvc.allproducts.view.AllProductAdaptor;
import com.example.mvc.allproducts.view.AllProductClickListener;
import com.example.mvc.model.Product;
import com.example.mvc.model.Repo;
import com.example.mvc.network.ProductNetworkCallback;
import com.example.mvc.network.ProductClient;
import com.example.mvc.network.ProductNetworkCallback;
import com.example.mvc.network.ProductResponse;
import java.util.ArrayList;
import java.util.List;

public class AllProductActivity extends AppCompatActivity implements AllProductClickListener {

    private RecyclerView recyclerView;
    private AllProductAdaptor adapter;
    private Button backButton;
    private List<Product> productList = new ArrayList<>();
    private Repo repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_products);

        repo = Repo.getInstance(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AllProductAdaptor(productList, this);
        recyclerView.setAdapter(adapter);

        fetchProducts();

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> finish());
    }

    private void fetchProducts() {
        ProductClient client = new ProductClient();
        client.makeNetworkCall(new ProductNetworkCallback() {
            @Override
            public void onSuccessResult(ProductResponse productResponse) {
                if (productResponse != null && productResponse.getProducts() != null) {
                    productList.clear();
                    productList.addAll(productResponse.getProducts());
                    runOnUiThread(() -> adapter.notifyDataSetChanged());
                }
            }

            @Override
            public void onFailureResult(String error) {
                // Handle error
            }
        });
    }

    @Override
    public void onAddToFavClick(Product product) {
        repo.insert(product);
    }
}