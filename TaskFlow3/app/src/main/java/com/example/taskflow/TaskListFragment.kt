package com.example.taskflow

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class TaskListFragment : Fragment() {

    private lateinit var buttonAddTask: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstance: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_task_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonAddTask = view.findViewById(R.id.buttonAddTask)

        buttonAddTask.setOnClickListener {
            (requireContext() as MainActivity).launchAddTask()
        }
    }
}