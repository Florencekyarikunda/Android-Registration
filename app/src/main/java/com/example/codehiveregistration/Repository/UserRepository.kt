package com.example.codehiveregistration.Repository

import com.example.codehiveregistration.Api.ApiClient
import com.example.codehiveregistration.Api.ApiInterface
import com.example.codehiveregistration.Models.LoginRequest
import com.example.codehiveregistration.Models.LoginResponse
import com.example.codehiveregistration.Models.RegistrationRequest
import com.example.codehiveregistration.Models.RegistrationResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    var apiInterface = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun registrationStudents(registrationRequest:RegistrationRequest):Response<RegistrationResponse> =
    withContext(Dispatchers.IO){
        var response=apiInterface.RegisterStudent(registrationRequest)
        return@withContext response
    }
//  suspend fun login(loginRequest: LoginRequest):Response<LoginResponse>

}