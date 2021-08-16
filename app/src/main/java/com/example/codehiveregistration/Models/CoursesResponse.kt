package com.example.codehiveregistration.Models

data class CoursesResponse(
    var date_created: String,
    var date_updated: String,
    var created_by: String,
    var active: Boolean,
    var course_id: String,
    var course_name: String,
    var course_code: String,
    var description: String,
    var instructor: String,
    val updated_by: CharSequence
)
