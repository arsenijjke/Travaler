package com.example.travaler

import com.example.travaler.model.UserModel
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Component(modules = [AppModule::class])
interface AppComponent {


}

@Module
class AppModule{

   // @Provides
   // fun provideUser(
   //     userModel: UserModel
   // ) : UserModel {
   //     return UserModel()
   // }
}

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://json-generator.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create()
    }
}