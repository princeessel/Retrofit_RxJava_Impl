package com.example.retrofit_rxjava_impl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {
    private static String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CompositeDisposable compositeDisposable;
    private PostApi postApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compositeDisposable = new CompositeDisposable();
        //initialize views

        Retrofit retrofit = PostApiService.getInstance();
        postApi = retrofit.create(PostApi.class);

        recyclerView = (RecyclerView) findViewById(R.id.post_recyclerview_a);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        fetchData();

    }

    private void fetchData() {
        compositeDisposable.add(postApi.getAllPost()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Post>>() {
                    @Override
                    public void accept(List<Post> posts) throws Exception {
                        PostAdapter adapter = new PostAdapter(this, posts);
                        recyclerView.setAdapter(adapter);

                    }
                }));
    }

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }
}


