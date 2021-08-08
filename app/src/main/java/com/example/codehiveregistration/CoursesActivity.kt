package com.example.codehiveregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_courses)
        var rvCourses=findViewById<RecyclerView>(R.id.rvCourses)
            var coursesList= listOf(Courses("MN78","Mobile Development","Introduction to Android","John Omour"),
                Courses("mk90","Python","Introduction to Djago","John Omour"),
                Courses("MN8","UX Research","Introduction to UX","Joy"),
                Courses("YU8","Javascript","Introduction to DOM","Purity Maina"),
                Courses("RT8","IoT","Introduction to Internet Of Things","Barrey Yassin"))

    var CoursesAdapter=CoursesAdapter(coursesList)
        rvCourses.layoutManager=LinearLayoutManager(baseContext)
        rvCourses.adapter=CoursesAdapter
    }
}