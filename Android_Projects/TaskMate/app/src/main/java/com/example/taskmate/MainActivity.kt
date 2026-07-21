package com.example.taskmate

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmate.adapter.TaskAdapter
import com.example.taskmate.model.Task
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var addTaskButton: FloatingActionButton


    companion object {
        val taskList = ArrayList<Task>()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.taskRecyclerView)

        addTaskButton = findViewById(R.id.addTaskButton)


        // Add Task Button Click

        addTaskButton.setOnClickListener {

            val intent = Intent(this, AddTaskActivity::class.java)

            startActivity(intent)

        }


        // RecyclerView Setup

        taskAdapter = TaskAdapter(taskList)


        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = taskAdapter


    }


    override fun onResume() {

        super.onResume()


        if(::taskAdapter.isInitialized){

            taskAdapter.notifyDataSetChanged()

        }

    }

}