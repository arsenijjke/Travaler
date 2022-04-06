package com.example.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitObject {

    companion object {
        private const val BASE_URL = "https://github.com/arsenijjke/Travaler/"
    }

    fun <Api> buildApi(
        api: Class<Api>
    ): Api {
        return Retrofit.Builder()
            .baseUrl(Companion.BASE_URL)
            .client(OkHttpClient.Builder().also { client ->
                val logger = HttpLoggingInterceptor()
                logger.level = HttpLoggingInterceptor.Level.BODY
                client.addInterceptor(logger)
            }.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)


    }
}