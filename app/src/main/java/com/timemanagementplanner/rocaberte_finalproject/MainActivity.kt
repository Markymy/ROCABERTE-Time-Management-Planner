package com.timemanagementplanner.rocaberte_finalproject

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var scheduleList: MutableList<Schedule>
    private lateinit var scheduleAdapter: ScheduleAdapter
    private lateinit var recyclerView: RecyclerView

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the schedule list and adapter
        scheduleList = mutableListOf()
        scheduleAdapter = ScheduleAdapter(scheduleList)

        // Set up the RecyclerView
        recyclerView = findViewById(R.id.scheduleRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = scheduleAdapter

        // Set up the "Add Schedule" button
        val addScheduleButton = findViewById<FloatingActionButton>(R.id.addScheduleButton)
        addScheduleButton.setOnClickListener {
            val intent = Intent(this, AddScheduleActivity::class.java)
            startActivityForResult(intent, ADD_SCHEDULE_REQUEST_CODE)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ADD_SCHEDULE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val newSchedule = data?.getParcelableExtra<Schedule>(/* name = */ "newSchedule")
            if (newSchedule != null) {
                // Add the new schedule to the list
                scheduleList.add(newSchedule)
                scheduleAdapter.notifyDataSetChanged()
            }
        }
    }

    companion object {
        const val ADD_SCHEDULE_REQUEST_CODE = 1
    }
}
