package com.example.pickapp.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Data (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val code: String,
    val factory: String,
    val distribution: String
)
