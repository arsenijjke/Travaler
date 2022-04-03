package com.example.data.network.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.data.network.database.models.UserEntity

@Dao
interface UserDao {

    @Insert
    suspend fun addUser(user: UserEntity)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<UserEntity>>
}