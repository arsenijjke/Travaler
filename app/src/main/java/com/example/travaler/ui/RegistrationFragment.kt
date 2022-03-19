package com.example.travaler.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travaler.R
import com.example.travaler.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment(R.layout.fragment_registration) {

    private val binding: FragmentRegistrationBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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