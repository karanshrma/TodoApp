package com.example.todoapp

import NotesAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todoapp.databinding.FragmentSecondBinding

class SecondFragment : DialogFragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private val tasksViewModel: TasksViewModel by activityViewModels()

    private lateinit var notesAdapter: NotesAdapter // Assuming this is initialized elsewhere

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the adapter if it's not initialized elsewhere
        notesAdapter = NotesAdapter(tasksViewModel.tasks)

        binding.SaveTask.setOnClickListener {
            val newTaskTitle = binding.editextAddTask.text.toString().trim()
            if (newTaskTitle.isNotEmpty()) {
                val newTask = Note(newTaskTitle)
                tasksViewModel.addTask(newTask)
//                notesAdapter.addTask(newTask)
                Toast.makeText(context, "Task Saved", Toast.LENGTH_SHORT).show()
//                findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            } else {
                Toast.makeText(context, "Task title cannot be empty", Toast.LENGTH_SHORT).show()

            }

        }


//        binding.cancelButton.setOnClickListener {
//
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
