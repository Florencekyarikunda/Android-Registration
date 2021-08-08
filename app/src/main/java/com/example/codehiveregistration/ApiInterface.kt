package com.example.codehiveregistration

import com.example.codehiveregistration.Models.RegistrationRequest
import com.example.codehiveregistration.Models.RegistrationResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
@POST("/students/register")
fun RegisterStudent(@Body RegistrationRequest: RegistrationRequest):retrofit2.Call<RegistrationResponse>
}

