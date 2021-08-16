package com.example.codehiveregistration.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.codehiveregistration.R

class CourseDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_detail)
        var btnCourseDetails=findViewById<Button>(R.id.btnCourseDetails)
        btnCourseDetails.setOnClickListener {
            var intent = Intent(baseContext,Login::class.java)
            startActivity(intent)
        }
    }
}
