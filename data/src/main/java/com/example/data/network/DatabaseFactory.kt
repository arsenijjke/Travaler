package com.example.data.network

import com.example.domain.Database
import com.example.domain.DatabaseType
import com.example.data.network.UserDatabase

open class DatabaseFactory : Database(){

    override fun create(type: DatabaseType): Database {
        if(type == DatabaseType.USER_DAO) return UserDatabase()
        else{
            TODO()
        }
    }
}