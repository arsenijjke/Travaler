package com.example.travaler

import dagger.Component
import dagger.Module

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

}