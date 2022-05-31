package com.example.pickapp.room

import androidx.room.*

@Dao
interface DataDao {

    @Insert
    suspend fun addData(data: Data)

    @Update
    suspend fun updateData(data: Data)

    @Delete
    suspend fun deleteData(data: Data)

    @Query("SELECT * FROM data")
    suspend fun getDatas():List<Data>

    @Query ("SELECT * FROM data WHERE id=:data_id")
    suspend fun getData(data_id: Int): List<Data>
}