package com.example.codehiveregistration.Models

import com.google.gson.annotations.SerializedName

data class RegistrationRequest(
    var Name: String,
    @SerializedName("Phone NUmber") var PhoneNumber: String,
    val Email: String,
    @SerializedName("DOB") var DOB: String,
    var Nationality: String,
    var Password: String,
)
