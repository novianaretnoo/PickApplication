package com.example.pickapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val intentButton: Button = findViewById(R.id.btn_signup)
        intentButton.setOnClickListener { viewDetail() }

        //val intentButton2: TextView = findViewById(R.id.tv_signup)
        //intentButton.setOnClickListener { viewDetail2() }
    }

    /*private fun viewDetail2() {
        val intent = Intent(this,SignupActivity::class.java)
        startActivity(intent)
        finish()
    }*/

    private fun viewDetail() {
        val intent = Intent(this,CheckActivity::class.java)
        startActivity(intent)
        finish()
    }
}