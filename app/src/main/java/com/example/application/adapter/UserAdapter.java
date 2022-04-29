package com.example.application.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.R;
import com.example.application.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    List<User> listUser;

    public UserAdapter(List<User> listUser) {
        this.listUser = listUser;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_user_viewholder, parent, false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.layout.findViewById(R.id.uFundoLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        ((TextView) holder.layout.findViewById(R.id.uId)).setText(Integer.toString(listUser.get(position).getId()));
        ((TextView) holder.layout.findViewById(R.id.uName)).setText(listUser.get(position).getName());
        ((TextView) holder.layout.findViewById(R.id.uUserName)).setText(listUser.get(position).getUserName());
        ((TextView) holder.layout.findViewById(R.id.uEmail)).setText(listUser.get(position).getEmail());
        //((TextView) holder.layout.findViewById(R.id.uAddress)).setText(listUser.get(position).getAddress().toString());
        ((TextView) holder.layout.findViewById(R.id.uPhone)).setText(listUser.get(position).getPhone());
        ((TextView) holder.layout.findViewById(R.id.uWebsite)).setText(listUser.get(position).getWebsite());
        //((TextView) holder.layout.findViewById(R.id.uCompany)).setText(listUser.get(position).getCompany().toString());
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        public View layout;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            this.layout = itemView;
        }
    }
}
