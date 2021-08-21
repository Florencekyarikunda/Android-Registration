package com.example.registration.ui

import android.R
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import androidx.core.content.ContextCompat.startActivity
import com.example.codehiveregistration.Models.RegistrationRequest
import com.example.codehiveregistration.UI.CourseDetailActivity
import com.example.codehiveregistration.UI.LoginActivity
import com.example.codehiveregistration.ViewModel.UserViewModel
import com.example.codehiveregistration.constants
import com.example.codehiveregistration.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val userViewModel: UserViewModel by viewModels()
lateinit var sharedPreferences: SharedPreferences
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        redirect()



        sharedPreferences = getSharedPreferences(constants.SHAREDPREFS, Context.MODE_PRIVATE)
    }
        var nationality = arrayListOf<String>("Kenyan", "Ugandan", "Rwandese", "South Sudanes")
        var nationalityAdapter =
            ArrayAdapter(baseContext, R.layout.simple_spinner_item, nationality)
//        binding.spNationality.adapter = nationalityAdapter
//        nationalityAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
//        binding.btnRegister.setOnClickListener {
//            var intent = Intent(baseContext, LoginActivity::class.java)
//            startActivity(intent)
//        }

fun redirect(){
    var accessToken=sharedPreferences.getString(constants.ACCESS_TOKEN,constants.EMPTY_STRING)
    if (accessToken!!.isNotEmpty()){
        startActivity(Intent(baseContext,CourseDetailActivity::class.java))

    }
    else{
        startActivity(Intent(baseContext,LoginActivity::class.java))
    }
}

    override fun onResume() {
        super.onResume()
        binding.btnRegister.setOnClickListener {
            if (binding.etname.text.toString().isEmpty() ||
                binding.etDateOfBirth.text.toString().isEmpty() ||
                binding.etphoneNumber.text.toString().isEmpty() ||
                binding.etEmail.text.toString().isEmpty() ||
                binding.etPassword.text.toString().isEmpty()


            ) {
                binding.etname.setError("Name required")
                binding.etDateOfBirth.setError("Date of birth required")
                binding.etphoneNumber.setError("Number required")
                binding.etEmail.setError("Email required")
                binding.etPassword.setError("Password required")

            }


            var regRequest = RegistrationRequest(
                Name = binding.etname.text.toString(),
                PhoneNumber = binding.etphoneNumber.text.toString(),
                Email = binding.etEmail.text.toString(),
                DOB = binding.etDateOfBirth.text.toString(),
                Password = binding.etPassword.text.toString(),
                Nationality = binding.spNationality.selectedItem.toString().uppercase()
            )

            var intent = Intent(baseContext, LoginActivity::class.java)
            startActivity(intent)

            userViewModel.registerUser(regRequest)
        }
        userViewModel.registrationLiveData.observe(this) { regResponse ->
            if (!regResponse.studentId.isNullOrEmpty()) {
                Toast.makeText(baseContext, "Registration successful", Toast.LENGTH_LONG).show()
            }
        }
        userViewModel.regErrorLiveData.observe(this) { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        }
    }
}

