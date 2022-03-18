package com.example.travaler.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travaler.R
import com.example.travaler.databinding.LoginFragmentBinding
import com.example.travaler.model.viewmodels.AuthViewModel

class LoginFragment : Fragment(R.layout.login_fragment) {

    private val binding: LoginFragmentBinding by viewBinding()
    private lateinit var viewModel: AuthViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth()
    }

    fun auth(){
        binding.btnLogin.setOnClickListener {
            viewModel.check(
                binding.login.toString(),
                binding.password.toString()
            )
        }
    }

    fun CANNOTWAITTODIEINTHEMOMENT() {
        binding.registration.setOnClickListener {

        }
    }


}