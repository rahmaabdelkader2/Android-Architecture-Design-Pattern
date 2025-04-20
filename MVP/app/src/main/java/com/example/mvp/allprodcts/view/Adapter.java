package com.example.mvp.allprodcts.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvp.R;
import com.example.mvp.model.Pojo.Product;

import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.ProductViewHolder> {
    private List<Product> products;
    private OnProductClickListener listener;
    public Adapter(List<Product> products, OnProductClickListener listener) {
        this.products = products;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_products, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products.get(position);
        holder.bind(product);
        holder.title.setText(product.getTitle());
        holder.price.setText(String.format("$%.2f", product.getPrice()));

        holder.addToFavBtn.setOnClickListener(v -> {
            listener.OnAddToFavClick(product);
        });


    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView productThumbnail;
        TextView title, price, description;

        Button addToFavBtn;


        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productThumbnail = itemView.findViewById(R.id.productThumbnail);

            title = itemView.findViewById(R.id.productTitle);
            price = itemView.findViewById(R.id.productPrice);
            addToFavBtn = itemView.findViewById(R.id.addfavbtn);

        }
        public void bind(Product product) {
            title.setText(product.title);
            price.setText(String.format("$%.2f", product.price));
            Glide.with(productThumbnail.getContext())
                    .load(product.thumbnail)
                    .into(productThumbnail);
        }

    }
}