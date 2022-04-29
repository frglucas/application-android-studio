package com.example.application.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.R;
import com.example.application.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> listPost;

    public PostAdapter(List<Post> listPost) {
        this.listPost = listPost;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_post_viewholder, parent, false);

        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.layout.findViewById(R.id.fundoLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        ((TextView) holder.layout.findViewById(R.id.cPostId)).setText(Integer.toString(listPost.get(position).getUserId()));
        ((TextView) holder.layout.findViewById(R.id.postId)).setText(Integer.toString(listPost.get(position).getId()));
        ((TextView) holder.layout.findViewById(R.id.postTitle)).setText(listPost.get(position).getTitle());
        ((TextView) holder.layout.findViewById(R.id.postBody)).setText(listPost.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return listPost.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        public View layout;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            this.layout = itemView;
        }
    }
}
