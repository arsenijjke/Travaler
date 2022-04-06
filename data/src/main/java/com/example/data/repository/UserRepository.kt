package com.example.data.repository

import androidx.lifecycle.LiveData
import com.example.data.database.User
import com.example.data.database.UserDao

class UserRepository(private val userDao: UserDao) {

    val readAllData = userDao.readAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }
}