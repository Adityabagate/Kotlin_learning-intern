package com.example.taskmate.model

data class Task(
    val title: String,
    val description: String,
    var isCompleted: Boolean = false
)