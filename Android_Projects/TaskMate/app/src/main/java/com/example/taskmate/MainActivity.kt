package com.example.taskmate

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmate.adapter.TaskAdapter
import com.example.taskmate.model.Task

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var taskAdapter: TaskAdapter

    private val taskList = ArrayList<Task>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.taskRecyclerView)


        // Dummy Tasks
        taskList.add(
            Task(
                "Learn Kotlin",
                "Complete Android basics"
            )
        )

        taskList.add(
            Task(
                "Build TaskMate",
                "Create To-Do List application"
            )
        )


        taskAdapter = TaskAdapter(taskList)


        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = taskAdapter

    }
}