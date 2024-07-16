package com.example.todoapp

import androidx.lifecycle.ViewModel

class TasksViewModel : ViewModel() {
    val tasks: MutableList<Note> = mutableListOf(
        Note("Task 1"),
        Note("Task 2"),
        Note("Task 3")

    )

    fun addTask(note: Note) {
        tasks.add(note)
    }
}
