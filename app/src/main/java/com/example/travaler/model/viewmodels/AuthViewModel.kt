package com.example.travaler.model.viewmodels

import androidx.lifecycle.ViewModel
import com.example.data.network.repository.AuthRepository

class AuthViewModel(
    private val repository: AuthRepository
) : ViewModel() {


}