package com.example.codehiveregistration.ViewModel

import com.example.codehiveregistration.Models.EnrolmentResponse
import com.example.codehiveregistration.Repository.CoursesRepository

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class EnrolViewModel: ViewModel() {
    var enrolLiveData = MutableLiveData<EnrolmentResponse>()
    var enrolmentError = MutableLiveData<String>()
    var coursesRepository = CoursesRepository()

    fun enrol(accessToken: String){
        viewModelScope.launch {
            var response = coursesRepository.enrol(accessToken)
            if (response.isSuccessful){
                enrolLiveData.postValue(response.body())
            }
            else{
                enrolmentError.postValue(response.errorBody()?.string())
            }
        }
    }
}