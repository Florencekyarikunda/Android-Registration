package com.example.codehiveregistration.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codehiveregistration.Models.CoursesResponse
import com.example.codehiveregistration.Repository.CoursesRepository
import kotlinx.coroutines.launch

class CoursesViewModel:ViewModel() {
    var CoursesLiveData = MutableLiveData<List<CoursesResponse>>()
    var CoursesFailedLiveData = MutableLiveData<String>()
    var CoursesRepository = CoursesRepository()

    fun CoursesList(){
        viewModelScope.launch {
            var response = CoursesRepository.Courses()
            if (response.isSuccessful){
                CoursesLiveData.postValue(response.body())
            }
            else{
                CoursesFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}