package com.example.myhello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvRegister.setOnClickListener{
            val Intent= Intent(baseContext,RegistrationActivity::class.java)
            startActivity(intent)
        }
        btnLogIn.setOnClickListener {
            var UserName=tvEmail.text.toString()
            var Password=tvPassword.text.toString()
            Toast.makeText(baseContext,Password,Toast.LENGTH_SHORT).show()
        }



    }
}