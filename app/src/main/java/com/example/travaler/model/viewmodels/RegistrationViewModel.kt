package com.example.travaler.model.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Resource
import kotlinx.coroutines.launch
import com.example.data.repository.AuthRepository
import com.example.domain.models.LoginResponse

class RegistrationViewModel(
    private val repository: AuthRepository
) : ViewModel() {

    private val _loginResponse: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Resource<LoginResponse>>
        get() = _loginResponse

    fun createAccount(
        email: String,
        password: String
    ) = viewModelScope.launch {
            _loginResponse.value = repository.createAccount(email, password)
    }
}