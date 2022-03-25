package com.mialskywalker.todolist.adapter;

import com.mialskywalker.todolist.model.Task;

public interface OnToDoClickListener {
    void onToDoClick(Task task);
    boolean onToDoRadioButtonClick(Task task);
    void onToDoTrashButtonClick(Task task);
}
