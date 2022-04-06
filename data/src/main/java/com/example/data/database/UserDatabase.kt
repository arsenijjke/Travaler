package com.example.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.util.Converter
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [User::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class UserDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        var INSTANCE: UserDatabase? = null

        @InternalCoroutinesApi
        fun getDatabase(context: Context): UserDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null) return tempInstance

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_table"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}