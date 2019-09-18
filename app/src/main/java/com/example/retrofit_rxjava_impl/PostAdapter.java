package com.example.retrofit_rxjava_impl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.functions.Consumer;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private List<Post> postList;
    Consumer<List<Post>> context;

    public PostAdapter(Consumer<List<Post>> context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }


    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        holder.textViewId.setText(postList.get(position).getId().toString());
        holder.textViewName.setText(postList.get(position).getName());
        holder.textViewEmail.setText(postList.get(position).getEmail());
        holder.textViewBody.setText(postList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewId, textViewName, textViewEmail, textViewBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.post_reclerview_id);
            textViewName = itemView.findViewById(R.id.post_reclerview_name);
            textViewEmail = itemView.findViewById(R.id.post_reclerview_email);
            textViewBody = itemView.findViewById(R.id.post_reclerview_body);
        }
    }
}
