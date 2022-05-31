package com.example.pickapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Middle (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val kode: String,
    val warehouse: String,
    val wholesaler: String
)
