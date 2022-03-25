package com.mialskywalker.todolist.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.mialskywalker.todolist.model.Task;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    void insertTask(Task task);

    @Query("DELETE FROM task_table")
    void deleteAll();

    @Query("SELECT * FROM task_table WHERE task_table.is_done == 0")
    LiveData<List<Task>> getTasks();

    @Query("SELECT * FROM task_table WHERE task_table.task_id == :id")
    LiveData<Task> get(long id);

    @Query("SELECT * FROM task_table WHERE task_table.is_done")
    LiveData<List<Task>> getDoneTasks();


    @Update
    void update(Task task);

    @Delete
    void delete(Task task);

}
