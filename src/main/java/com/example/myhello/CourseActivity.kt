package com.example.myhello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_course.*

class CoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)
        var courseList = listOf<Courses>(
            Courses("1", "Python", "PY 101", "James Neumann", "Python Intro"),
            Courses("2", "Android", "AND 201", "Anne Elson", "Android development training"),
            Courses("3", "Database", "DB 304", "Kamwe Wema", "Database administration and development"),
            Courses("4", "Network", "DIS 202", "Betty Crocker", "Netwok Config for modern apps")
        )
        rvCourses.layoutManager = LinearLayoutManager(baseContext)
        rvCourses.adapter = CoursesAdapter(courseList)
    }
}