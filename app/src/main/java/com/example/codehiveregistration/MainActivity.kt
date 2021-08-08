package com.example.codehiveregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.*
import com.example.codehiveregistration.Models.RegistrationRequest
import com.example.codehiveregistration.Models.RegistrationResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var etDOB: EditText
    lateinit var spNationality: Spinner
    lateinit var etPhoneNumber: EditText
    lateinit var etEmail: EditText
    lateinit var btnRegister: Button
    lateinit var etPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()
    }

    fun castViews(){
        etName = findViewById(R.id.etName)
        etDOB = findViewById(R.id.etDOB)
        spNationality = findViewById(R.id.spNationality)
        etPassword = findViewById(R.id.etPassword)
        etPhoneNumber = findViewById(R.id.etPhoneNumber)
        etEmail = findViewById(R.id.etEmail)
        btnRegister = findViewById(R.id.btnRegister)

        var nationalities = arrayOf("Kenyan", "Rwandan", "South Sudanese", "Sudanese", "Ugandan")
        var nationalitiesAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, nationalities)
        nationalitiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spNationality.adapter = nationalitiesAdapter

        clickRegister()
    }

    fun clickRegister(){
        var error = false
        btnRegister.setOnClickListener {
            var name = etName.text.toString()
            if(name.isEmpty()){
                error = true
                etName.setError("Name is required")
            }
            var DOB = etDOB.text.toString()
            var nationality = spNationality.selectedItem.toString()
            var password = etPassword.text.toString()
            var phone = etPhoneNumber.text.toString()
            var email = etEmail.text.toString()
            if(email.isEmpty()){
                error=true
                etEmail.setError("Name is required")
            }

            var registrationRequest = RegistrationRequest(Name = name,
                PhoneNumber = phone,
//                email:Email,
                nationality = nationality.toUpperCase(),
                DOB = DOB,
                Password = password)


            val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
            var request = retrofit.RegisterStudent(registrationRequest)
            request.enqueue(object : Callback<RegistrationResponse> {
                override fun onResponse(call: Call<RegistrationResponse>, response: Response<RegistrationResponse>) {
                    if (response.isSuccessful){
                        Toast.makeText(baseContext, "Registration Successful", Toast.LENGTH_LONG).show()
                    }
                    else{
                        try {
                            val error = JSONObject(response.errorBody()!!.string())
                            Toast.makeText(baseContext, error.toString(), Toast.LENGTH_LONG)
                                .show()
                        } catch (e: Exception) {
                            Toast.makeText(baseContext, e.message, Toast.LENGTH_LONG).show()
                        }
                    }
                }

                override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}
data class ApiError(var errors: List<String>)
