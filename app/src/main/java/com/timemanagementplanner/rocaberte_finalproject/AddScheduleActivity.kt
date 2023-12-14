package com.timemanagementplanner.rocaberte_finalproject

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddScheduleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_schedule)

        val activityNameEditText = findViewById<EditText>(R.id.activityNameEditText)
        val startTimeEditText = findViewById<EditText>(R.id.startTimeEditText)
        val endTimeEditText = findViewById<EditText>(R.id.endTimeEditText)
        val saveScheduleButton = findViewById<Button>(R.id.saveScheduleButton)

        saveScheduleButton.setOnClickListener {
            val activityName = activityNameEditText.text.toString()
            val startTime = startTimeEditText.text.toString()
            val endTime = endTimeEditText.text.toString()

            if (activityName.isNotEmpty() && startTime.isNotEmpty() && endTime.isNotEmpty()) {
                val newSchedule = Schedule(activityName, startTime, endTime)
                val resultIntent = Intent()
                resultIntent.putExtra("newSchedule", newSchedule)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}
