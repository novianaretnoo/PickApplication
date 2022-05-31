package com.example.pickapp.database

import androidx.room.*
import com.example.pickapp.room.Data

@Dao
interface MiddleDao {

    @Insert
    suspend fun addMiddle(middle : Middle)

    @Update
    suspend fun updateMiddle(middle : Middle)

    @Delete
    suspend fun deleteMiddle(middle : Middle)

    @Query("SELECT * FROM middle")
    suspend fun getMiddles():List<Middle>

    //@Query("SELECT * FROM middle WHERE id=:middle_id")
    //suspend fun getMiddle(data_id: Int): List<Middle>
}