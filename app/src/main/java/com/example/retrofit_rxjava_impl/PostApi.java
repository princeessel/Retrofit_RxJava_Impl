package com.example.retrofit_rxjava_impl;


import java.util.List;

import io.reactivex.Observable;


import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostApi {
    @GET("posts/1/comments")
    Observable<List<Post>> getAllPost();
}