package com.example.codehiveregistration.Models

import com.google.gson.annotations.SerializedName

data class RegistrationResponse(
    var Name:String,
    @SerializedName("phone_number") var PhoneNumber:String,
    var Email:String,
    @SerializedName("date of_birth") var DOB:String,
    var Nationality:String,
    var Password:String,
    @SerializedName("Student_id") var studentId:String
)

