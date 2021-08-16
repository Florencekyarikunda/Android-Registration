package com.example.codehiveregistration.UI

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.codehiveregistration.Models.LoginRequest
import com.example.codehiveregistration.databinding.ActivityLoginBinding
import android.content.Context


class Login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    val LoginViewModel:LoginViewModel by viewModels()
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("CODEHIVE_REG_PREFS", Context.MODE_PRIVATE)
        binding.btnLogin.setOnClickListener {
            var LoginRequest= LoginRequest(binding.tvEmail.text.toString(),
                binding.tvPassword.text.toString())
            LoginViewModel.Login(LoginRequest)
        }
    }

    override fun onResume(){
        super.onResume()
        LoginViewModel.LoginLiveData.observe(this, { logInResponse->
            Toast.makeText(baseContext, logInResponse.message, Toast.LENGTH_LONG).show()
            var accessToken = logInResponse.accessToken
            sharedPreferences.edit().putString("ACCESS_TOKEN", accessToken).apply()
            var x = sharedPreferences.getString("ACCESS_TOKEN", "")
        })

        LoginViewModel.LoginFailedLiveData.observe(this, {error->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
            binding.tvLogin.visibility=View.VISIBLE
            binding.tvLogin.text = error
        })
        val intent = Intent(baseContext, CoursesActivity::class.java)
        startActivity(intent)
    }





















//        views()
//        logIn()

//    lateinit var etEmailLogIn: EditText
//    lateinit var etPasswordLogIn: EditText
//    lateinit var btnLogIn: Button

//    fun views() {
//        etEmailLogIn = findViewById(R.id.etEmailLogIn)
//        etPasswordLogIn = findViewById(R.id.etPasswordLogIn)
//        btnLogIn = findViewById(R.id.btnLogIn)
//
//    }
//
//    fun logIn() {
//
//        var error = false
//        btnLogIn.setOnClickListener {
//            var logInEmail = etEmailLogIn.text.toString()
//            if (logInEmail.isEmpty()) {
//                error = true
//                etEmailLogIn.setError("Email is required")
//            }
//            var idLogInPassword = etPasswordLogIn.text.toString()
//            if (idLogInPassword.isEmpty()) {
//                error = true
//                etPasswordLogIn.setError("ID Number required")
//            }
//
//            var logInRequest = LogInRequest(
//                email = logInEmail,
//                password = idLogInPassword
//            )
//
//
//            val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
//            var request = retrofit.logInStudent(logInRequest)
//            request.enqueue(object : Callback<LogInResponse> {
//
//                override fun onResponse(
//                    call: Call<LogInResponse>,
//                    response: Response<LogInResponse>
//                ) {
//                    if (response.isSuccessful) {
//                        Toast.makeText(baseContext, "LogIn successful", Toast.LENGTH_LONG)
//                            .show()
//                    }
//                }
//
//                override fun onFailure(call: Call<LogInResponse>, t: Throwable) {
//                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
//                }
//
//            })
//            val intent = Intent(baseContext, CoursesActivity::class.java)
//            startActivity(intent)
//        }
//
//    }
}

class LoginViewModel {

}
