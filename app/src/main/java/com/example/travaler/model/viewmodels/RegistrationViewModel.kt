package com.example.travaler.model.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.network.Api
import com.example.domain.models.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegistrationViewModel @Inject constructor(private val api: Api) : ViewModel() {
    fun call() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                Log.d("XD", api.createUser(
                    "arsenikjke",
                    "password",
                    "photoExmpl",
                ).result)
            } catch (e: Exception){
                Log.d("XD", e.toString())
            }
        }
    }

}