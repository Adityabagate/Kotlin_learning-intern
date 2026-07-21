package com.example.taskmate

import com.example.taskmate.model.Task
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddTaskActivity : AppCompatActivity() {

    private lateinit var titleInput: EditText
    private lateinit var descriptionInput: EditText
    private lateinit var saveButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_add_task)


        titleInput = findViewById(R.id.taskTitleInput)
        descriptionInput = findViewById(R.id.taskDescriptionInput)
        saveButton = findViewById(R.id.saveTaskButton)


        saveButton.setOnClickListener {

            val title = titleInput.text.toString()
            val description = descriptionInput.text.toString()


            // Abhi temporary close karenge
            if(title.isNotEmpty()) {

                MainActivity.taskList.add(
                    Task(
                        title,
                        description
                    )
                )

            }

            finish()

        }

    }
}