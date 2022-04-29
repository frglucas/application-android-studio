package com.example.application.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.R;
import com.example.application.model.Todos;

import java.util.List;

public class TodosAdapter extends RecyclerView.Adapter<TodosAdapter.TodosViewHolder> {

    private List<Todos> listTodos;

    public TodosAdapter(List<Todos> listTodos) {
        this.listTodos = listTodos;
    }

    @NonNull
    @Override
    public TodosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_todos_viewholder, parent, false);

        return new TodosAdapter.TodosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodosViewHolder holder, int position) {
        holder.layout.findViewById(R.id.tFundoLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        ((TextView) holder.layout.findViewById(R.id.tUserId)).setText(Integer.toString(listTodos.get(position).getUserId()));
        ((TextView) holder.layout.findViewById(R.id.tId)).setText(Integer.toString(listTodos.get(position).getId()));
        ((TextView) holder.layout.findViewById(R.id.tTitle)).setText(listTodos.get(position).getTitle());
        ((TextView) holder.layout.findViewById(R.id.tCompleted)).setText(String.valueOf(listTodos.get(position).isCompleted()));
    }

    @Override
    public int getItemCount() {
        return listTodos.size();
    }

    class TodosViewHolder extends RecyclerView.ViewHolder {
        public View layout;
        public TodosViewHolder(@NonNull View itemView) {
            super(itemView);
            this.layout = itemView;
        }
    }
}
