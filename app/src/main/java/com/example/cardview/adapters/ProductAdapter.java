package com.example.cardview.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardview.R;
import com.example.cardview.models.Product;
import com.squareup.picasso.Picasso;

import java.util.LinkedList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    //usar una linkenlist
    LinkedList<Product> products ;

    public ProductAdapter(LinkedList<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_products, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {
        Product product = products.get(position);

        Picasso.with(holder.itemView.getContext()).load(product.getThumbnail()).into(holder.imgProducto);

        holder.texTitulo.setText(product.getTitle());
        holder.texMarca.setText(product.getBrand());
        holder.texPrecio.setText(String.valueOf(product.getPrice()));
        holder.texPuntuacion.setText(String.valueOf(product.getRating()));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgProducto;
        TextView texTitulo, texPrecio, texMarca, texPuntuacion;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            imgProducto = itemView.findViewById(R.id.imgProducto);
            texTitulo = itemView.findViewById(R.id.texTitulo);
            texPrecio = itemView.findViewById(R.id.texPrecio);
            texMarca = itemView.findViewById(R.id.texMarca);
            texPuntuacion = itemView.findViewById(R.id.texPuntuacion);
        }
    }
}
