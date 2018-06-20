package com.example.az.nambatest.api;

import android.provider.SyncStateContract;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface ApiService {

    @FormUrlEncoded
    @POST("fares/")
    Call<ResponseBody> postRegistr(@Field("server_token") String server_token, @Field("partner_id") int partner_id);

    @Multipart
    @POST("fares/")
    Call<ResponseBody> myPost(@Part("server_token") RequestBody server_token, @Part("partner_id") int partner_id);
}
