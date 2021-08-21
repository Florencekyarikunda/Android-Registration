package com.example.codehiveregistration.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codehiveregistration.Models.CoursesResponse
import com.example.codehiveregistration.Repository.CoursesRepository
import kotlinx.coroutines.launch

class CoursesViewModel:ViewModel() {
    var CoursesLiveData = MutableLiveData<List<CoursesResponse>>()
    var CoursesErrorLiveData = MutableLiveData<String>()
    var CoursesRepository = CoursesRepository()

    fun getList(){
        viewModelScope.launch {
            var response = CoursesRepository.getCourses(accessToken)
            if (response.isSuccessful){
                CoursesLiveData.postValue(response.Body()?.string())
            }
            else{
                CoursesErrorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}