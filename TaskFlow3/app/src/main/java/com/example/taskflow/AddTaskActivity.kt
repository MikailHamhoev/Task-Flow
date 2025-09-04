package com.example.taskflow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddTaskActivity : AppCompatActivity() {
    private lateinit var editTitle: EditText
    private lateinit var editDescription: EditText
    private lateinit var buttonSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        editTitle = findViewById(R.id.editTitle)
        editDescription = findViewById(R.id.editDescription)
        buttonSave = findViewById(R.id.buttonSave)

        buttonSave.setOnClickListener {
            val title = editTitle.text.toString().trim()
            val description = editDescription.text.toString().trim()

            if (title.isNotEmpty()) {
                val resultIntent = Intent()
                resultIntent.putExtra("TASK_TITLE", title)
                resultIntent.putExtra("TASK_DESCRIPTION", description)

                setResult(RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}