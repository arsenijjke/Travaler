package com.example.data.network

import com.example.domain.models.Response
import com.example.domain.models.UserModel
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {

    @POST("/api/v1/users")
    suspend fun createUser(
        @Query("nickname") nickname: String,
        @Query("password") password: String,
        @Query("photo") photo: String
    ) : Response

}