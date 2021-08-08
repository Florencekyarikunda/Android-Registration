package com.example.codehiveregistration;

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.codehiveregistration.Models.LoginRequest
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class LoginActivity : AppCompatActivity() {
    lateinit var tvEmail:TextView
    lateinit var tvPassword:TextView
    lateinit var btnLogin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    castViews()
    }
    fun castViews(){
        tvEmail=findViewById(R.id.tvEmail)
        tvPassword=findViewById(R.id.tvPassword)
        btnLogin=findViewById(R.id.btnLogin)
    clickRegister()
    }
    fun  clickRegister(){
        var error=false
        btnLogin.setOnClickListener {
            var email=tvEmail.text.toString()
            if (email.isEmpty()){
                error=true
                tvEmail.setError("Email is required")
            }
            var password=tvPassword.text.toString()
            if (password.isEmpty()){
                error=true
                tvPassword.setError("Password is required")
            }
            var loginRequest= LoginRequest(
                Email=email,Password=password
            )
            val retrofit=ApiClient.buildApiClient(ApiInterface::class.java)
            var request=retrofit.login(loginRequest)
            val enqueue = request.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        Toast.makeText(baseContext, "Login successful", Toast.LENGTH_LONG).show()
                        var intent = Intent(baseContext, CoursesActivity::class.java)
                        startActivity(intent)

                    } else {
                        try {
                            val error = JSONObject(response.errorBody()!!.string())
                            Toast.makeText(baseContext, error.toString(), Toast.LENGTH_LONG).show()
                        } catch (e: Exception) {
                            Toast.makeText(baseContext, e.message, Toast.LENGTH_LONG).show()
                        }
                    }
                }

              override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }
            })

        }
    }
}