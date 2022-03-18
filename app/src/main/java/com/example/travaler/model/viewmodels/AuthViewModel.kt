package com.example.travaler.model.viewmodels

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.travaler.model.UserModel

class AuthViewModel : ViewModel() {

    fun check(login: String, password: String) {
        Toast.makeText(null, "Auth is complete", Toast.LENGTH_LONG).show()
    }

}