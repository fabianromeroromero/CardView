package com.example.cardview.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.cardview.R;
import com.example.cardview.adapters.ProductAdapter;
import com.example.cardview.database.ApiDummyJsonClient;
import com.example.cardview.models.Product;
import com.example.cardview.models.ResponseApi;
import com.example.cardview.services.ApiDummyjso;

import java.util.LinkedList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvProductos;
    ProductAdapter productAdapter;
    LinkedList<Product> productos ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvProductos = findViewById(R.id.rvProductos);
        rvProductos.setLayoutManager(new LinearLayoutManager(this));
        obtenerProducto();
    }

    private LinkedList<Product> obtenerProducto(){
        productos = new LinkedList<>();
        ApiDummyjso api = ApiDummyJsonClient.getClient().create(ApiDummyjso.class);

        Call<ResponseApi> call = api.getAllProduct();

        call.enqueue(new Callback<ResponseApi>() {
            @Override
            public void onResponse(Call<ResponseApi> call, Response<ResponseApi> response) {
                if(response.isSuccessful()){
                    productAdapter = new ProductAdapter(response.body().getProducts());
                    rvProductos.setAdapter(productAdapter);
                }else {
                    Toast.makeText(MainActivity.this,"Error de usuario",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseApi> call, Throwable t) {
                System.out.println("Error servidor: "+t.getMessage());
                Toast.makeText(MainActivity.this,"Error en el servidor",Toast.LENGTH_LONG).show();
            }
        });
        return productos;
    }
}