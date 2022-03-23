package com.mialskywalker.todolist.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.mialskywalker.todolist.model.Task;
import com.mialskywalker.todolist.util.TaskRoomDatabase;

import java.util.List;

public class ToDoRepository {

    private final TaskDao taskDao;
    private final LiveData<List<Task>> allTasks;

    public ToDoRepository(Application application) {
        TaskRoomDatabase database = TaskRoomDatabase.getDatabase(application);
        taskDao = database.taskDao();
        allTasks = taskDao.getTasks();
    }

    public LiveData<List<Task>> getAllTasks() {
        return allTasks;
    }

    public void insert(Task task) {
        TaskRoomDatabase.databaseWriterExecutor.execute(() -> taskDao.insertTask(task));
    }

    public LiveData<Task> get(long id) { return taskDao.get(id); }

    public void update(Task task) {
        TaskRoomDatabase.databaseWriterExecutor.execute(() -> taskDao.update(task));
    }

    public void delete(Task task) {
        TaskRoomDatabase.databaseWriterExecutor.execute(() -> taskDao.delete(task));
    }
}
