package com.example.codehiveregistration.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codehiveregistration.Models.LoginRequest
import com.example.codehiveregistration.Repository.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {
    var LoginLiveData = MutableLiveData<String>()
    var LoginFailedData = MutableLiveData<String>()
    var UserRepository = UserRepository()


    fun Login(LoginRequest:LoginRequest){
        viewModelScope.launch {
            var response = UserRepository.Login(LoginRequest,)
            if (response.isSuccessful){
                LoginLiveData.postValue(response.body())
            }
            else{
                LoginFailedData.postValue(response.errorBody()?.string())
            }
        }
    }
}