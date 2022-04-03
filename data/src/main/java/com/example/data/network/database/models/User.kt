package com.example.data.network.database.models

import android.net.Uri
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey val id: Int,
    val nickname: String,
    val password: String,
    val photo: Uri
)