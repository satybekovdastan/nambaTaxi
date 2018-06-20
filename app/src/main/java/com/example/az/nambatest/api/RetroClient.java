package com.example.az.nambatest.api;

import android.content.Context;
import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {

    static Context context;

    private static final String ROOT_URL = "https://partners.staging.swift.kg/api/v1/";

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getApiService(Context context2) {
        context = context2;
        return getRetrofitInstance().create(ApiService.class);
    }



}