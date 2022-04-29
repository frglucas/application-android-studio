package com.example.application.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.R;
import com.example.application.model.Photo;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {

    private List<Photo> listPhoto;

    public PhotoAdapter(List<Photo> listPhoto) {
        this.listPhoto = listPhoto;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_photo_viewholder, parent, false);

        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        holder.layout.findViewById(R.id.pFundoLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        ((TextView) holder.layout.findViewById(R.id.pAlbumId)).setText(Integer.toString(listPhoto.get(position).getAlbumId()));
        ((TextView) holder.layout.findViewById(R.id.pId)).setText(Integer.toString(listPhoto.get(position).getId()));
        ((TextView) holder.layout.findViewById(R.id.pTitle)).setText(listPhoto.get(position).getTitle());
        ((TextView) holder.layout.findViewById(R.id.pUrl)).setText(listPhoto.get(position).getUrl());
        ((TextView) holder.layout.findViewById(R.id.pThumbnailUrl)).setText(listPhoto.get(position).getThumbnailUrl());
    }

    @Override
    public int getItemCount() {
        return listPhoto.size();
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder {
        public View layout;
        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            this.layout = itemView;
        }
    }
}
