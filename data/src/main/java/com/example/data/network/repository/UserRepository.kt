package com.example.data.network.repository

import androidx.lifecycle.LiveData
import com.example.data.network.database.UserDao
import com.example.data.network.database.models.UserEntity

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<UserEntity>> = userDao.readAllData()

    suspend fun addUser(user: UserEntity) {
        userDao.addUser(user)
    }
}