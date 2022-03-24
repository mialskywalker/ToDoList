package com.mialskywalker.todolist.adapter;

import com.mialskywalker.todolist.model.Task;

public interface OnToDoClickListener {
    void onToDoClick(int adapterPosition, Task task);
    void onToDoRadioButtonClick(Task task);
}
