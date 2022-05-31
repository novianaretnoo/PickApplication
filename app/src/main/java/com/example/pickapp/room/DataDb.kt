package com.example.pickapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//holder class pake annotation buat nampilin 'daftar dari entity' yang ada
@Database(
    entities = [Data::class],
    version = 1
)
abstract class DataDb : RoomDatabase(){

    abstract fun dataDao() : DataDao

    companion object {

        @Volatile private var instance : DataDb? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            DataDb::class.java,
            "firstmile.db"
        ).build()
    }
}