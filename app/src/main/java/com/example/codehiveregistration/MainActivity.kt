package com.example.codehiveregistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner


class MainActivity : AppCompatActivity() {


    lateinit var etName:EditText
    lateinit var etDOB: EditText
    lateinit var spNationality:Spinner
    lateinit var etPhoneNumber: EditText
    lateinit var etEmail: EditText
    lateinit var btnRegister:Button
    lateinit var etIdNumber: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()
        clickRegister()
//        var etName=findViewById<EditText>(R.id.etName)
//        var etDOB=findViewById<EditText>(R.id.etDOB)
//        var etPhoneNumber=findViewById<EditText>(R.id.etPhoneNumber)
//        var etIdNumber=findViewById<EditText>(R.id.etIdNumber)
//        var spNationality=findViewById<Spinner>(R.id.spNationality)
//        var etEmail=findViewById<EditText>(R.id.etEmail)
//        var btnRegister=findViewById<Button>(R.id.btnRegister)
//
//        btnRegister.setOnClickListener {
//
//        }
        }
        fun castViews(){

            etName = findViewById(R.id.etName)
            etDOB  = findViewById(R.id.etDOB)
            spNationality = findViewById(R.id.spNationality)
            etEmail = findViewById(R.id.etEmail)
            etPhoneNumber = findViewById(R.id.etPhoneNumber)
            btnRegister = findViewById(R.id.btnRegister)
            etIdNumber = findViewById(R.id.etIdNumber)
            val nationality = arrayOf("Kenyan", "Ugandan", "Rwandan", "South Sudan")
            var nationalityAdapter = ArrayAdapter<String>(baseContext, android.R.layout.simple_spinner_item, nationality)
            nationalityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spNationality.adapter = nationalityAdapter
        }
    fun clickRegister(){
            btnRegister.setOnClickListener {
                var name = etName.text.toString()
                if (name.isEmpty()) {
                    etName.setError("Name is required")
                }
                var dob = etDOB.text.toString()
                if (dob.isEmpty()) {
                    etDOB.setError("Date of birth is required")
                }
                var idNumber = etIdNumber.text.toString()
                if (idNumber.isEmpty()){
                    etIdNumber.setError("ID Number required")
                }
                var nationality = spNationality.selectedItem.toString()
                var email = etEmail.text.toString()
                if (email.isEmpty()){
                    etEmail.setError("Email required")
                }
                var phoneNumber = etPhoneNumber.text.toString()
                if (phoneNumber.isEmpty()){
                    etPhoneNumber.setError("Input phone number")
                }
//                var details = Register(
//                    name = name, dob = dob, nationality = "",
//                    idNumber = idNumber, email = email, phoneNumber = phoneNumber
//                )
//        Toast.makeText(baseContext, details.toString(), Toast.LENGTH_LONG).show()
                val intent =Intent(baseContext,MainActivity::class.java)
                startActivity(intent)
            }
        }
//        data class Register(var name: String,
//                            var dob: String,
//                            var nationality: String,
//                            var idNumber: String,
//                            var email: String,
//                            var phoneNumber: String)
    }


