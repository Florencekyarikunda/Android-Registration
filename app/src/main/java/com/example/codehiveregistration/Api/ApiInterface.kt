package com.example.codehiveregistration.Api

import com.example.codehiveregistration.Models.LoginRequest
import com.example.codehiveregistration.Models.LoginResponse
import com.example.codehiveregistration.Models.RegistrationRequest
import com.example.codehiveregistration.Models.RegistrationResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/students/register")
    suspend fun RegisterStudent(@Body RegistrationRequest: RegistrationRequest): retrofit2.Response<RegistrationResponse>

    @POST("/students/login")
    suspend fun loginStudent(@Body loginRequest: LoginRequest): Response<LoginResponse>
}