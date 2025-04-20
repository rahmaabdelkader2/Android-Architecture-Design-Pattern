package com.example.mvp.favproducts.view;


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

public class FavAdaptor extends RecyclerView.Adapter<FavAdaptor.ProductViewHolder> {
    private List<Product> products;
    private OnFavClickListener listener;
    public FavAdaptor(List<Product> products, OnFavClickListener listener) {
        this.products = products;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fav_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products.get(position);
        holder.title.setText(product.getTitle());
        holder.price.setText(String.format("$%.2f", product.getPrice()));
        Glide.with(holder.itemView.getContext())
                .load(product.getThumbnail())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.image);
        holder.removeFromFavBtn.setOnClickListener(v -> {
            listener.onFavRemoveClick(product);
        });


    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title, price;

        Button removeFromFavBtn;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.productThumbnail2);
            title = itemView.findViewById(R.id.productTitle2);
            price = itemView.findViewById(R.id.productPrice2);
            removeFromFavBtn = itemView.findViewById(R.id.remove);



        }
    }
}