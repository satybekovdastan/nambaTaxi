package com.example.az.nambatest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.az.nambatest.api.ApiService;
import com.example.az.nambatest.api.RetroClient;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postNamba();

    }

    public void postNamba() {

        final ProgressDialog uploading;
        uploading = ProgressDialog.show(MainActivity.this, "Загрузка", "Подождите...", false, false);

        ApiService api = RetroClient.getApiService(MainActivity.this);
        retrofit2.Call<ResponseBody> call;
        call = api.postRegistr("w45rl5fssjcwNa0Z1Og6MoIJc9rPPmnl", 19);
        call.enqueue(new retrofit2.Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, final retrofit2.Response<ResponseBody> response) {
                uploading.dismiss();
                Log.e("CODE", response.code() + "");
                Log.e("RESPONCE", response.code() + "");
                if (response.isSuccessful()) {
                    Log.e("TOEKNE ", response.body().toString() + "");
                    try {
                        Log.e("TOEKNE ", response.body().string() + "");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(MainActivity.this, jObjError.getString("message"), Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }

                }

            }

            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                uploading.dismiss();
                Toast.makeText(MainActivity.this, t.getMessage() + "", Toast.LENGTH_SHORT).show();
                Log.e("TAG", "FAIL" + t.getMessage());
            }
        });
    }

}
