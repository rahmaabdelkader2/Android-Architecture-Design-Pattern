package com.example.mvc.favproducts.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.mvc.R;
import com.example.mvc.model.Product;
import java.util.ArrayList;
import java.util.List;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.FavViewHolder> {

    private List<Product> products = new ArrayList<>();
    private FavOnClickListener clickListener;

    public FavAdapter(FavOnClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fav_item, parent, false);
        return new FavViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavViewHolder holder, int position) {
        Product product = products.get(position);
        holder.bind(product);
        holder.removeButton.setOnClickListener(v -> clickListener.onRemoveFromFavClick(product));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    static class FavViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView priceTextView;
        private ImageView thumbnailImageView;
        private Button removeButton;

        public FavViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.productTitle2);
            priceTextView = itemView.findViewById(R.id.productPrice2);
            thumbnailImageView = itemView.findViewById(R.id.productThumbnail2);
            removeButton = itemView.findViewById(R.id.remove);
        }

        public void bind(Product product) {
            titleTextView.setText(product.title);
            priceTextView.setText(String.format("$%.2f", product.price));
            Glide.with(thumbnailImageView.getContext())
                    .load(product.thumbnail)
                    .into(thumbnailImageView);
        }
    }
}