package repository

import com.example.data.network.Api

class AuthRepository(
    private val api: Api
): BaseRepository() {

    suspend fun check(
        login: String,
        password: String
    ) = safeCallApi {
        api.createUser(login, password)
    }
}