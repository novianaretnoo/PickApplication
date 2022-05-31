package com.example.pickapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AddActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add2)
        val intentButton: Button = findViewById(R.id.btn_save)
        intentButton.setOnClickListener { viewDetail() }
    }

    private fun viewDetail() {
        val intent = Intent(this,DataActivity2::class.java)
        startActivity(intent)
        finish()
    }
}