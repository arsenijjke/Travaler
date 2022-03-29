package com.example.travaler.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.data.network.Api
import com.example.travaler.databinding.LoginFragmentBinding
import com.example.travaler.model.viewmodels.AuthViewModel
import com.example.data.network.repository.AuthRepository

class AuthFragment : BaseFragment<AuthViewModel, LoginFragmentBinding, AuthRepository>() {

    override fun getViewModel(): Class<AuthViewModel> = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = LoginFragmentBinding.inflate(inflater, container, false)

    override fun getRepository() = AuthRepository(retrofit.buildApi(api = Api::class.java))

    fun setViews() {
        auth()
        toRegistration()
    }

    private fun auth() {
        binding.btnLogin.setOnClickListener {

        }
    }


    private fun toRegistration() {
        binding.registration.setOnClickListener {
            findNavController().navigate(
                AuthFragmentDirections.loginToRegistration()
            )
        }
    }


}