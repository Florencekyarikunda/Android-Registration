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
        holder.tvCourseName.text=currentCourse.tvCourseName
        holder.tvDescription.text=currentCourse.tvDescription
        holder.tvInstructor.text=currentCourse.tvInstructor
        holder.tvCourseCode.text=currentCourse.tvCourseCode
    }

    override fun getItemCount(): Int {
        return CourseList.size
    }
}

class CoursesViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var tvCourseName = itemView.findViewById<TextView>(R.id.tvCourseName)
    var tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)
    var tvInstructor = itemView.findViewById<TextView>(R.id.tvCourseName)
    var tvCourseCode = itemView.findViewById<TextView>(R.id.tvCode)
}

