package com.mialskywalker.todolist;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.mialskywalker.todolist.model.Priority;
import com.mialskywalker.todolist.model.Task;
import com.mialskywalker.todolist.model.TaskViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TaskViewModel taskViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        taskViewModel = new ViewModelProvider.AndroidViewModelFactory(MainActivity
                .this.getApplication())
                .create(TaskViewModel.class);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Task task = new Task("Todo", Priority.HIGH, Calendar.getInstance().getTime(),
                    Calendar.getInstance().getTime(), false);

            TaskViewModel.insert(task);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
