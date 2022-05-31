package com.example.pickapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Middle::class],
    version = 1
)
abstract class MiddleDb : RoomDatabase(){

    abstract fun middleDao() : MiddleDao

    companion object {

        @Volatile private var instance : MiddleDb? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            MiddleDb::class.java,
            "middlemile.db"
        ).build()
    }
}