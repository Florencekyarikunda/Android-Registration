package com.example.codehiveregistration

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.codehiveregistration.UI.Courses

class CoursesAdapter (var CourseList:List<Courses>):RecyclerView.Adapter<CoursesViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
      var itemView = LayoutInflater.from(parent.context)
          .inflate(R.layout.courses_list_item,parent,false)
    return CoursesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) { var currentCourse=CourseList.get(position)
        holder.tvCourseName.text=currentCourse.CourseName
        holder.tvDescription.text=currentCourse.Description
        holder.tvInstructor.text=currentCourse.Instructor
        holder.tvCourseCode.text=currentCourse.CourseCode

    }

    override fun getItemCount(): Int {
        return CourseList.size
    }
}

class CoursesViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var tvCourseName = itemView.findViewById<TextView>(R.id.tvCourseName)
    var tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)
    var tvInstructor = itemView.findViewById<TextView>(R.id.tvCourseName)
    var tvCourseCode = itemView.findViewById<TextView>(R.id.tvCourseCode)
}

