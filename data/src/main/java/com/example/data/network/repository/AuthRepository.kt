package com.example.data.network.repository

import com.example.data.network.Api

class AuthRepository(
    private val api: Api
): BaseRepository() {

    suspend fun createAccount(
        login: String,
        password: String
    ) = safeCallApi {
        api.createUser(login, password)
    }

    suspend fun login(
        login: String,
        password: String
    ) = safeCallApi {
    }

}