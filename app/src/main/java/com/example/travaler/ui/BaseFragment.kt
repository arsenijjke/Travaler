package com.example.travaler.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.data.database.UserDao
import com.example.data.network.RetrofitObject
import com.example.travaler.model.viewmodels.ViewModelFactory
import com.example.data.repository.BaseRepository

abstract class BaseFragment<VM : ViewModel, B : ViewBinding, R : BaseRepository> : Fragment() {

    protected lateinit var binding: B
    protected lateinit var viewModel: VM
    protected val retrofit = RetrofitObject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getFragmentBinding(inflater,container)
        val factory = ViewModelFactory(getRepository())
        viewModel = ViewModelProvider(this, factory = factory).get(getViewModel())
        return binding.root
    }

    abstract fun getViewModel(): Class<VM>

    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): B

    abstract fun getRepository(): R
}