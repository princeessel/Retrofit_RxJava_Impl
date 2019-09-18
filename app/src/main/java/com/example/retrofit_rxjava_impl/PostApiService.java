package com.example.retrofit_rxjava_impl;

import android.content.Context;
import android.database.Observable;

import org.reactivestreams.Subscriber;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostApiService {
private PostApi postApi;
private List<Post> postList;
    private static String BASE_URL = "https://jsonplaceholder.typicode.com/";
private static Retrofit retrofit = null;



    public static Retrofit getInstance() {
        if (retrofit == null)
             retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        return retrofit;
    }
    private PostApiService() {
}
}
