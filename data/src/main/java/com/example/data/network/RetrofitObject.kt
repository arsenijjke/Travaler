package com.example.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitObject {

    companion object {
        private const val BASE_URL = ""

    }

    fun <Api> buildApi(
        api: Class<Api>
    ): Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }
}