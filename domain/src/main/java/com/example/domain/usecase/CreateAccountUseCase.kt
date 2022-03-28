package com.example.domain.usecase

import com.example.domain.models.UserRegistration

class CreateAccountUseCase {

    fun execute(param: UserRegistration): UserRegistration {
        return UserRegistration(nickname = "arsenijke", password = "123")
    }
}