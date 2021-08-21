package com.example.codehiveregistration.UI;

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.codehiveregistration.Models.LoginRequest
import com.example.codehiveregistration.ViewModel.LoginViewModel
import com.example.codehiveregistration.constants
import com.example.codehiveregistration.databinding.ActivityLoginBinding
import com.google.android.gms.dynamic.IFragmentWrapper
import android.content.SharedPreferences as SharedPreferences1

class LoginActivity : AppCompatActivity() {
    //    lateinit var tvEmail:TextView
//    lateinit var tvPassword:TextView
//    lateinit var btnLogin:Button
    lateinit var sharedPrefs: SharedPreferences1
    val loginViewModel: LoginViewModel by viewModels()
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPrefs = getPreferences("CODEHIVEREG_PREFS",Context.MODE_PRIVATE)

        binding.btnLogIn.setOnClickListener {
            var logInRequest = LoginRequest(
                binding.etLoginEmail.text.toString(),
                binding.etLoginPassword.text.toString())
            loginViewModel.Loginuser(logInRequest)
        }
    }

    override fun onResume() {
        super.onResume()
        binding.btnLogIn.setOnClickListener {
        binding.tvLoginError.visibility = View.GONE
            validateLogin()


        }
        loginViewModel.loginLiveData.observe(this, {logInResponse->
            binding.pbLogin.visibility = View.GONE
            Toast.makeText(baseContext, logInResponse.message, Toast.LENGTH_LONG).show()
//            var accessToken = logInResponse.accessToken
            var editor = sharedPrefs.edit()
//            sharedPrefs.edit().putString(constants.ACCESS_TOKEN, logInResponse.)
            editor.putString("ACCESS_TOKEN", logInResponse.acc)
            editor.putString(constants."STUDENT_ID" ,logInResponse.accessToken)
            editor.apply()
            //create a session manager
            //figure out how to add a log out - remove the session manager
//            var x = sharedPreferences.getString("ACCESS_TOKEN", "")
            startActivity(Intent(baseContext,CoursesActivity::class.java))
        })

        loginViewModel.loginErrorLiveData.observe(this, {error->
        Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
            binding.tvLoginError.visibility=View.VISIBLE
            binding.tvLoginError.text = error
        })
    }
//    fun redirectUser() {
//        var accessToken = sharedPrefs.getString(constants.ACCESS_TOKEN, constants.EMPTY_STRING)
//        if (accessToken!!.isNotEmpty()) {
//            startActivity(Intent(baseContext, CourseDetailActivity::class.java))
//        } else {
//            startActivity(Intent(baseContext, LoginActivity::class.java))
//        }

        fun validateLogin() {
            var email = binding.etLoginEmail.text.toString()
            var password = binding.etLoginPassword.text.toString()
            var error = false

            if (email.isBlank() || email.isEmpty()) {
                var error = true
                binding.etLoginEmail.setError("Email is required")

            }
            if (password.isBlank() || password.isEmpty()) {
                var error = true
                binding.etLoginPassword.setError("Password is required")

            }
            if (!error) {
                binding.pbLogin.visibility = View.GONE
            }
        }






















//    override fun onResume() {
//        super.onResume()
//        binding.btnLogin.setOnClickListener {
//            validateLogin()
//        }
//        loginViewModel.loginLiveData.observe(this,{loginResponse->
//    binding.progressBar2.visibility=View.GONE
//    Toast.makeText(baseContext,loginResponse.message,Toast.LENGTH_LONG).show()
//    var editor=sharedPrefs.edit()
//    editor.putString("STUDENT_ID",loginResponse.studentId)
//    editor.putString("ACCESS_TOKEN",loginResponse.accessToken)
//    editor.apply()
//    startActivity(baseContext,CourseDetailActivity::javaClass)
//
//})
//        loginViewModel.loginErrorLiveData.observe(this,{ error->
//           binding.tvLoginError.visibilty = View.VISIBLE
//            binding.tvLoginError.text= error
//            )}
//    }
//    fun validateLogin(etEmail: Any) {
//        var email = binding.etLoginEmail.text.toString()
//        var password=binding.etLoginPassword.text.toString()
//        var error = false
//        if (email.isBlank()) {
//            error = true
//            etEmail.setError("Email is required")
//
//            if (password.isBlank()) {
//                error = true
//                tvpassword.setError(
//                    "password is required")
//
//
//
//                if (!error){
//                    binding.progressBar2.visibility=View.VISIBLE
//                    var loginRequest=
//
//
//
//                        fun redirectUser(){
//
//                        }
//        }
//
//















//    fun castViews(){
//        tvEmail=findViewById(R.id.tvEmail)
//        tvPassword=findViewById(R.id.tvPassword)
//        btnLogin=findViewById(R.id.btnLogin)
//    clickRegister()
//    }
//    fun  clickRegister(){
//        var error=false
//        btnLogin.setOnClickListener {
//            var email=tvEmail.text.toString()
//            }
//            var password=tvPassword.text.toString()
//            if (password.isEmpty()){
//                error=true
//                tvPassword.setError("Password is required")
//            }
//            var loginRequest= LoginRequest(
//                Email=email,Password=password
//            )
//            val retrofit= ApiClient.buildApiClient(ApiInterface::class.java)
//            var request=retrofit.login(loginRequest)
//            val enqueue = request.enqueue(object : Callback<LoginResponse> {
//override fun onResponse(
//        call: Call<LoginResponse>,
//        response: Response<LoginResponse>
//    ) {
//        if (response.isSuccessful) {
//            Toast.makeText(baseContext, "Login successful", Toast.LENGTH_LONG).show()
//            var intent = Intent(baseContext, CoursesActivity::class.java)
//            startActivity(intent)
//
//        } else {
//            try {
//                val error = JSONObject(response.errorBody()!!.string())
//                Toast.makeText(baseContext, error.toString(), Toast.LENGTH_LONG).show()
//            } catch (e: Exception) {
//                Toast.makeText(baseContext, e.message, Toast.LENGTH_LONG).show()
//            }
//
//        }
//    }
//
//  override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//        Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
//    }
//})

}
    }
}