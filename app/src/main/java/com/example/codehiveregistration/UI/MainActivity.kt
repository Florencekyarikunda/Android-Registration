package com.example.registration.ui

import android.R
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import com.example.codehiveregistration.Models.RegistrationRequest
import com.example.codehiveregistration.UI.Login
import com.example.codehiveregistration.ViewModel.UserViewModel
import com.example.codehiveregistration.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val userViewModel: UserViewModel by viewModels()


    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var nationality = arrayListOf<String>("Kenyan", "Ugandan", "Rwandese", "South Sudanes")
        var nationalityAdapter =ArrayAdapter(baseContext, R.layout.simple_spinner_item, nationality)
        binding.spNationality.adapter=nationalityAdapter
        nationalityAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.btnLogin.setOnClickListener {
            var intent = Intent(baseContext, Login::class.java)
            startActivity(intent)
        }
    }


    override fun onResume() {
        super.onResume()
        binding.btnRegister.setOnClickListener{
            if (binding.etName.editText.toString().isEmpty()||
                binding.etDOB.editText.toString().isEmpty()||
                binding.etPhoneNumber.text.toString().isEmpty()||
                binding.etEmail.text.toString().isEmpty() ||
                binding.etPassword.text.toString().isEmpty()


            ){
                binding.etName.setError("Name required")
                binding.etDOB.setError("Date of birth required")
                binding.etPhoneNumber.setError("Number required")
                binding.etEmail.setError("Email required")
                binding.etPassword.setError("Password required")

            }

            var Name = binding.etName.editText.toString()
            var DOB = binding.etDOB.editText.toString()
            var PhoneNumber = binding.etPassword.text.toString()
            var Email = binding.etEmail.text.toString()
            var Password = binding.etPassword.text.toString()

            var regRequest = RegistrationRequest(
                Name = binding.etName.text.toString(),
                PhoneNumber = binding.etPhoneNumber.text.toString(),
                Email = binding.etEmail.text.toString(),
                DOB = binding.etDOB.text.toString(),
                Password = binding.etPassword.text.toString(),
                Nationality =binding.spNationality.selectedItem.toString().uppercase()
            )

            var intent = Intent(baseContext, Login::class.java)
            startActivity(intent)

            userViewModel.RegisterStudent(regRequest)
        }
        userViewModel.registrationLiveData.observe(this, { regResponse->
            if (!regResponse.studentId.isNullOrEmpty()){
                Toast.makeText(baseContext, "Registration successful", Toast.LENGTH_LONG).show()
            }
        })
        userViewModel.regFailedLiveData.observe(this, { error->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })
    }
