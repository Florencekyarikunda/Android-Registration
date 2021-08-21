package com.example.codehiveregistration.Api

import com.example.codehiveregistration.Models.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {
    @POST("/students/register")
    suspend fun RegisterStudent(@Body RegistrationRequest: RegistrationRequest):Response<RegistrationResponse>

    @POST("/students/login")
    suspend fun loginStudent(@Body loginRequest: LoginRequest): Response<LoginResponse>


    @GET("/courses")
    suspend fun studentCourses(@Header("Authorization")token:String):Response<List<CoursesResponse>>

    @POST("/enrolments")
    suspend fun enroll(@Header("Authorization") token: String): Response<EnrolmentResponse>
}
