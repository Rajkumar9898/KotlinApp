package com.example.kotlinapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinapp.R
import com.example.kotlinapp.preference.SharedPref

class LoginActivity : AppCompatActivity() {
    private lateinit var email: TextView
    private lateinit var password: TextView
//    var regexEmail = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"
//    var strRegEx = "^(?=.*[0-9]).{8,}$"
//    var regexChangeEmail = regexEmail.toRegex()
//    var regexPassword = strRegEx.toRegex()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        SharedPref.init(this)

        if (SharedPref.read("isLogin", false)) {
            val homeIntent = Intent(this, MainActivity::class.java)
            startActivity(homeIntent)
            finish()
        }
    }

    fun login(view: android.view.View) {
        val username = email.text.toString()
        val password = password.text.toString()

        var email = "razchaurasia5@gmail.com"
        var sPassword = "123456"

        SharedPref.write("username", username)
        SharedPref.write("password", password)
        SharedPref.write("isLogin", true)
//        if (username.matches(regexChangeEmail) && password.matches(regexPassword)) {
        if(username.equals(email) && password.equals(sPassword)){
            Toast.makeText(this, "Right Credential", Toast.LENGTH_SHORT).show()
            val homeIntent = Intent(this, MainActivity::class.java)
            startActivity(homeIntent)
            finish()

        } else {
            Toast.makeText(this, "Please write valid Email and Password", Toast.LENGTH_SHORT).show()
        }
    }
}


