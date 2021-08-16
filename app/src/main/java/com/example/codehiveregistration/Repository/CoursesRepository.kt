package com.example.codehiveregistration.Repository

import com.example.codehiveregistration.Api.ApiClient
import com.example.codehiveregistration.Api.ApiInterface
import com.example.codehiveregistration.Models.CoursesResponse
import com.google.android.gms.cast.framework.SessionManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


class CoursesRepository {
    lateinit var sessionManager: SessionManager
    var apiInterface = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun Courses(): Response<List<CoursesResponse>> =
        withContext(Dispatchers.IO){
            var response=apiInterface.studentCourses(token = "Bearer ${sessionManager.fetchAuthentication()}")
            return@withContext response
        }
}