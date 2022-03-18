package com.example.travaler

import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Component(modules = [AppModule::class])
interface AppComponent {

   // fun inject(mainActivity: MainActivity)
}

@Module
class AppModule{

 //  @Provides
 //  fun providesRetrofit() {

 //  }
}