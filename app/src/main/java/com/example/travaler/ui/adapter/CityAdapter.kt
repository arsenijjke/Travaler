package com.example.travaler.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.travaler.R
import com.example.travaler.databinding.FragmentCitiesBinding

class CityAdapter(private val cities: ArrayList<City>, val binding: FragmentCitiesBinding)
    : RecyclerView.Adapter<CityAdapter.ViewHolder>()
{

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val cityImage = itemView.findViewById<ImageView>(R.id.photo)
        val name = itemView.findViewById<TextView>(R.id.name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_city,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CityAdapter.ViewHolder, position: Int) {
        var currentItem = cities[position]
        holder.name.text = currentItem.name
        holder.cityImage.setImageBitmap(currentItem.photo)
    }

    override fun getItemCount(): Int {
        return cities.size
    }
}