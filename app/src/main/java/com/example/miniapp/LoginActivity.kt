package com.example.miniapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.miniapp.databinding.ActivityLoginBinding
import com.example.miniapp.databinding.ActivitySplashBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {

            if (binding.txtLogin.text.toString() == "admin" && binding.txtPassword.text.toString() == "admin") {
                val mainIntent = Intent(this, MainActivity::class.java)
                startActivity(mainIntent)
            } else Toast.makeText(applicationContext,"Wrong user name and password",Toast.LENGTH_SHORT).show()
        }
    }
}