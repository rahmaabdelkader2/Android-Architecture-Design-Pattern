package com.example.mvc.allproducts.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mvc.R;
import com.example.mvc.model.Product;
import com.bumptech.glide.Glide;
import java.util.List;

public class AllProductAdaptor extends RecyclerView.Adapter<AllProductAdaptor.ProductViewHolder> {

    private List<Product> productList;
    private AllProductClickListener clickListener;

    public AllProductAdaptor(List<Product> productList, AllProductClickListener clickListener) {
        this.productList = productList;
        this.clickListener = clickListener;
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
        Product product = productList.get(position);
        holder.bind(product);

        holder.Addfav.setOnClickListener(v -> {
            clickListener.onAddToFavClick(product);
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView priceTextView;
        private ImageView thumbnailImageView;
        private Button Addfav;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.productTitle);
            priceTextView = itemView.findViewById(R.id.productPrice);
            thumbnailImageView = itemView.findViewById(R.id.productThumbnail);
            Addfav = itemView.findViewById(R.id.addfavbtn);
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