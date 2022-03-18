package com.example.travaler.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.travaler.R
import com.example.travaler.databinding.FragmentStartBinding

class StartFragment : Fragment(R.layout.fragment_start) {

    private val binding: FragmentStartBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        next()
    }

    //Anim
    private fun fadeOut() {
        binding.begin.animate()
            .alpha(0f)
            .setDuration(100)
            .start()
    }

    fun next() {
        binding.begin.setOnClickListener {
            fadeOut()
            findNavController().navigate(
                StartFragmentDirections.actionStartFragmentToMainFragment()
            )
        }
    }
}