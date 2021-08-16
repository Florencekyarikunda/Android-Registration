package com.example.codehiveregistration.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codehiveregistration.Models.RegistrationRequest
import com.example.codehiveregistration.Models.RegistrationResponse
import com.example.codehiveregistration.Repository.UserRepository
import kotlinx.coroutines.launch


class UserViewModel :ViewModel(){
    var registrationLiveData = MutableLiveData<RegistrationResponse>()
    var regErrorLiveData = MutableLiveData<String>()
    var UserRepository = UserRepository()
    fun registerUser(registrationRequest:RegistrationRequest){
       viewModelScope.launch {
           var response = UserRepository.registrationStudents(registrationRequest)
           if (response.isSuccessful){
               registrationLiveData.postValue(response.body())
           }
       else{
           regErrorLiveData.postValue(response.errorBody()?.string())

           }
       }
    }
}