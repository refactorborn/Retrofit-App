package com.ali.retrofitapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    @GET("recently-added/sub")
    Call<List<RecentlyAdded>> getSubbed();

}
