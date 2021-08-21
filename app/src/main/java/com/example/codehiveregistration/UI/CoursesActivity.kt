package com.example.codehiveregistration.UI

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codehiveregistration.CoursesAdapter
import com.example.codehiveregistration.Models.CoursesResponse
import com.example.codehiveregistration.R
import com.example.codehiveregistration.ViewModel.CoursesViewModel
import com.example.codehiveregistration.constants
import com.example.codehiveregistration.databinding.ActivityCoursesBinding
import com.example.codehiveregistration.databinding.CoursesListItemBinding
import okio.Utf8.size
import java.nio.file.Files.size

class CoursesActivity : AppCompatActivity() {
    lateinit var binding: ActivityCoursesBinding
    val CoursesViewModel:CoursesViewModel by viewModels()
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        binding = ActivityCoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

     override fun onResume() {
        super.onResume()
         var accessToken=sharedPreferences.getString(constants.ACCESS_TOKEN,constants.EMPTY_STRING)
         CoursesViewModel.CoursesLiveData.observe(this,{CoursesResponse->

             if (accessToken!!.isNotEmpty()){
                 CoursesViewModel.(accessToken)
             }
             CoursesViewModel.CoursesLiveData.observe(this,{Courses->
                 Toast.makeText(baseContext,"${CoursesListItemBinding.size} courses fetcher",Toast.LENGTH_LONG).show()

             })
             CoursesViewModel.CoursesErrorLiveData.observe(this,{ error->
                 Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
             })

         })
    }
}