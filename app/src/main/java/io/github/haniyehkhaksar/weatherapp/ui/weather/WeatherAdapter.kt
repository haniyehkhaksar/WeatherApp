package io.github.haniyehkhaksar.weatherapp.ui.weather

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.haniyehkhaksar.weatherapp.databinding.ItemWeatherBinding
import io.github.haniyehkhaksar.weatherapp.domain.domainmodel.WeatherDomainModel

class WeatherAdapter(private var items: MutableList<WeatherDomainModel>) :
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemWeatherBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    fun updateData(newItems: List<WeatherDomainModel>) {
        items.removeAll(items)
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemWeatherBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: WeatherDomainModel) {
            binding.info = item
            binding.executePendingBindings()
        }
    }
}