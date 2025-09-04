package com.example.taskflow

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var addTaskLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addTaskLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {result ->
            if (result.resultCode == RESULT_OK) {
                val title = result.data?.getStringExtra("TASK_TITLE")
                val description = result.data?.getStringExtra("TASK_DESCRIPTION")

                Toast.makeText(this, "Added: $title", Toast.LENGTH_LONG).show()
            }
        }

        if (supportFragmentManager.findFragmentById(R.id.container) == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, TaskListFragment())
                .commit()
        }
    }

    fun launchAddTask() {
        val intent = Intent(this, AddTaskActivity::class.java)
        addTaskLauncher.launch(intent)
    }
}