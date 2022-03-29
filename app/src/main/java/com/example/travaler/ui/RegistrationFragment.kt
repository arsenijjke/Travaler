package com.example.travaler.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.data.network.Api
import com.example.travaler.databinding.FragmentRegistrationBinding
import com.example.travaler.model.viewmodels.RegistrationViewModel
import com.example.data.network.repository.AuthRepository
import com.example.domain.models.Resource

class RegistrationFragment : BaseFragment<RegistrationViewModel, FragmentRegistrationBinding, AuthRepository>() {

    override fun getViewModel(): Class<RegistrationViewModel> = RegistrationViewModel::class.java

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentRegistrationBinding.inflate(inflater,container,false)

    override fun getRepository() = AuthRepository(retrofit.buildApi(api = Api::class.java))


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loginResponse.observe(viewLifecycleOwner, {
            when(it) {
                is Resource.Success -> { Toast.makeText(requireContext(),"Success",Toast.LENGTH_SHORT).show()}
                else -> Toast.makeText(requireContext(),"Failure",Toast.LENGTH_SHORT).show()
            }
        })
        setImage()
    }

    //TODO Refactor this later!!!
    private fun setImage() {
        val selectImage = registerForActivityResult(ActivityResultContracts.GetContent()) {
            binding.set1.setImageURI(it)
        }
        val selectImage1 = registerForActivityResult(ActivityResultContracts.GetContent()) {
            binding.set2.setImageURI(it)
        }
        val selectImage2 = registerForActivityResult(ActivityResultContracts.GetContent()) {
            binding.set3.setImageURI(it)
        }
        with(binding) {
            set1.setOnClickListener { selectImage.launch("image/*") }
            set2.setOnClickListener { selectImage1.launch("image/*") }
            set3.setOnClickListener { selectImage2.launch("image/*") }
        }
    }


}
