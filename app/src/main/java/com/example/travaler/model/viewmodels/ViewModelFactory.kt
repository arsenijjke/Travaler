package com.example.travaler.model.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.data.repository.AuthRepository
import com.example.data.repository.BaseRepository
import com.example.data.repository.UserRepository
import kotlinx.coroutines.InternalCoroutinesApi
import java.lang.IllegalArgumentException

class ViewModelFactory(
    private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory() {

    @InternalCoroutinesApi
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository) as T
            modelClass.isAssignableFrom(UserViewModel::class.java) -> RegistrationViewModel(repository as AuthRepository) as T
            else -> throw IllegalArgumentException("ViewModel class wasn`t found")
        }
    }
}