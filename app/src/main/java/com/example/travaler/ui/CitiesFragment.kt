package com.example.travaler.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.data.repository.CitiesRepository
import com.example.travaler.databinding.FragmentCitiesBinding
import com.example.travaler.model.viewmodels.CitiesViewModel

class CitiesFragment : BaseFragment<CitiesViewModel, FragmentCitiesBinding, CitiesRepository>() {

    override fun getViewModel(): Class<CitiesViewModel> {
        TODO("Not yet implemented")
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCitiesBinding = FragmentCitiesBinding.inflate(inflater, container, false)

    override fun getRepository(): CitiesRepository {
        TODO("Not yet implemented")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = GridLayoutManager(context,2)
        binding.cities.layoutManager = layoutManager
    }
}