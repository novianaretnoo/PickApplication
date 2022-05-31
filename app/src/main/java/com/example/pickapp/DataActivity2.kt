package com.example.pickapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DataActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data2)
        val intentButton: Button = findViewById(R.id.btn_tambah)
        intentButton.setOnClickListener { viewDetail() }
    }

    private fun viewDetail() {
        val intent = Intent(this,AddActivity2 ::class.java)
        startActivity(intent)
        finish()
    }
}