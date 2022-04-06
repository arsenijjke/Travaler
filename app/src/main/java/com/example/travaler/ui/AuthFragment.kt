package com.example.travaler.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.data.network.Api
import com.example.travaler.model.viewmodels.AuthViewModel
import com.example.data.repository.AuthRepository
import com.example.travaler.databinding.FragmentLoginBinding

class AuthFragment : BaseFragment<AuthViewModel, FragmentLoginBinding, AuthRepository>() {

    override fun getViewModel(): Class<AuthViewModel> = AuthViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLoginBinding.inflate(inflater, container, false)

    override fun getRepository() = AuthRepository(retrofit.buildApi(api = Api::class.java))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViews()
    }

    private fun setViews() {
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