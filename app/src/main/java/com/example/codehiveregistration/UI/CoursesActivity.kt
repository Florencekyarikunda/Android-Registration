package com.example.codehiveregistration.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codehiveregistration.CoursesAdapter
import com.example.codehiveregistration.Models.CoursesResponse
import com.example.codehiveregistration.R
import com.example.codehiveregistration.ViewModel.CoursesViewModel
import com.example.codehiveregistration.databinding.ActivityCoursesBinding

class CoursesActivity : AppCompatActivity() {
    lateinit var binding: ActivityCoursesBinding
    val CoursesViewModel:CoursesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        binding = ActivityCoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        var rvCourses=findViewById<RecyclerView>(R.id.rvCourses)
//            var coursesList= listOf(Courses("MN78","Mobile Development","Introduction to Android","John Omour"),
//                Courses("mk90","Python","Introduction to Djago","John Omour"),
//                Courses("MN8","UX Research","Introduction to UX","Joy"),
//                Courses("YU8","Javascript","Introduction to DOM","Purity Maina"),
//                Courses("RT8","IoT","Introduction to Internet Of Things","Barrey Yassin"))
//
//    var CoursesAdapter= CoursesAdapter(coursesList)
//        rvCourses.layoutManager=LinearLayoutManager(baseContext)
//        rvCourses.adapter=CoursesAdapter
    }

     override fun onResume() {
        super.onResume()
         CoursesViewModel.CoursesLiveData.observe(this,{CoursesResponse->

         })
    }
}