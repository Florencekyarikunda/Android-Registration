package com.example.codehiveregistration.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codehiveregistration.Models.LoginRequest
import com.example.codehiveregistration.Repository.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {

        var UserRepository = UserRepository()
        var loginLiveData = MutableLiveData<String>()
        var loginErrorLiveData = MutableLiveData<String>()


    fun Loginuser(LoginRequest:LoginRequest){
        viewModelScope.launch {
            var response = UserRepository.Login(LoginRequest)
            if (response.isSuccessful){
                loginLiveData.postValue(response.body().toString())
            }
            else{
                loginErrorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}