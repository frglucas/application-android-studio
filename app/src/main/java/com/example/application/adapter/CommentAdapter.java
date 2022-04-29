package com.example.application.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.R;
import com.example.application.model.Comment;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {

    private List<Comment> listComment;

    public CommentAdapter(List<Comment> listComment) {
        this.listComment = listComment;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_comment_viewholder, parent, false);

        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        holder.layout.findViewById(R.id.cFundoLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        ((TextView) holder.layout.findViewById(R.id.cPostId)).setText(Integer.toString(listComment.get(position).getPostId()));
        ((TextView) holder.layout.findViewById(R.id.cUserId)).setText(Integer.toString(listComment.get(position).getId()));
        ((TextView) holder.layout.findViewById(R.id.cName)).setText(listComment.get(position).getName());
        ((TextView) holder.layout.findViewById(R.id.cEmail)).setText(listComment.get(position).getEmail());
        ((TextView) holder.layout.findViewById(R.id.cBody)).setText(listComment.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return listComment.size();
    }


    class CommentViewHolder extends RecyclerView.ViewHolder {
        public View layout;
        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            this.layout = itemView;
        }
    }
}
