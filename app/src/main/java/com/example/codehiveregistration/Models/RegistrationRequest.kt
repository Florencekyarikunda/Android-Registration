package com.example.codehiveregistration.Models

data class RegistrationRequest(
    var Name: String,
    var DOB: String,
    var PhoneNumber: String,
    var nationality: String,
    var Password: String,
    val Email: String,
)
