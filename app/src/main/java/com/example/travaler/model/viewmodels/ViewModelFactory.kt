package com.example.travaler.model.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import repository.AuthRepository
import repository.BaseRepository
import java.lang.IllegalArgumentException

class ViewModelFactory(
    private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository) as T
            modelClass.isAssignableFrom(RegistrationViewModel::class.java) -> RegistrationViewModel(repository as AuthRepository) as T
            else -> throw IllegalArgumentException("ViewModel class wasn`t found")
        }
    }
}