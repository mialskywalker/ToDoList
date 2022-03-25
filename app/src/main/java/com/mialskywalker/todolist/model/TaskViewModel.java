package com.mialskywalker.todolist.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mialskywalker.todolist.data.ToDoRepository;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {

    public static ToDoRepository repository;
    public final LiveData<List<Task>> allTasks;
    public final LiveData<List<Task>> doneTasks;


    public TaskViewModel(@NonNull Application application) {
        super(application);
        repository = new ToDoRepository(application);
        allTasks = repository.getAllTasks();
        doneTasks = repository.getDoneTasks();
    }

    public LiveData<List<Task>> getAllTasks() { return allTasks; }
    public LiveData<List<Task>> getDoneTasks() { return doneTasks; }
    public static void insert(Task task) { repository.insert(task); }
    public LiveData<Task> get(long id) { return repository.get(id); }
    public static void update(Task task) { repository.update(task); }
    public static void delete(Task task) { repository.delete(task); }
}
