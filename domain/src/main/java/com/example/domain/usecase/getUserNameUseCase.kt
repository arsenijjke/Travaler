package com.example.domain.usecase

import com.example.domain.models.UserModel

class getUserNameUseCase {

    fun execute(): UserModel{
        return UserModel(nickname = "arsenijjke",id = 1,password ="rere", photo ="uriEx")
    }
}