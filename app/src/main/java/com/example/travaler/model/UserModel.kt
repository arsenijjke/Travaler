package com.example.travaler.model

import android.net.Uri

data class UserModel(
    val nickname: String,
    val id: Int,
    val password: String,
    val photo: Uri,
    val posts: List<PostModel>
    )
