package com.example.cardview.services;

import com.example.cardview.models.Product;
import com.example.cardview.models.ResponseApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiDummyjso {
    @GET("products")
    Call<ResponseApi> getAllProduct();
}
