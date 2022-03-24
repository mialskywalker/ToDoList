package com.mialskywalker.todolist.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.mialskywalker.todolist.R;
import com.mialskywalker.todolist.model.Task;
import com.mialskywalker.todolist.util.Utils;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final List<Task> taskList;
    private final OnToDoClickListener toDoClickListener;

    public RecyclerViewAdapter(List<Task> taskList, OnToDoClickListener onToDoClickListener) {
        this.taskList = taskList;
        this.toDoClickListener = onToDoClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Task task = taskList.get(position);
        String formatted = Utils.formatDate(task.getDueDate());

        holder.task.setText(task.getTask());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public AppCompatRadioButton radioButton;
        public AppCompatTextView task;

        OnToDoClickListener onToDoClickListener;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            radioButton = itemView.findViewById(R.id.todo_radio_button);
            task = itemView.findViewById(R.id.todo_row_todo);
            this.onToDoClickListener = toDoClickListener;

            itemView.setOnClickListener(this);
            radioButton.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            Task currTask = taskList.get(getAdapterPosition());
            int id = view.getId();
            if (id == R.id.todo_row_layout) {
                onToDoClickListener.onToDoClick(currTask);
            }else if (id == R.id.todo_radio_button) {
                currTask = taskList.get(getAdapterPosition());
                onToDoClickListener.onToDoRadioButtonClick(currTask);
            }
        }
    }

}
