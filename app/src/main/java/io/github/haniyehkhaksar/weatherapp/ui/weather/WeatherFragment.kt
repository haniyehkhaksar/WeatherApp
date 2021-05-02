package io.github.haniyehkhaksar.weatherapp.ui.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import dagger.android.support.DaggerFragment
import io.github.haniyehkhaksar.weatherapp.R
import io.github.haniyehkhaksar.weatherapp.databinding.WeatherFragmentBinding
import io.github.haniyehkhaksar.weatherapp.ui.SharedViewModel
import javax.inject.Inject

class WeatherFragment : DaggerFragment() {

    @Inject
    lateinit var viewModel: WeatherViewModel

    @Inject
    lateinit var sharedViewModel: SharedViewModel

    private val cityObserver = Observer<String> { city ->
        viewModel.getCurrentWeather(city)
        viewModel.getFutureWeather(city)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: WeatherFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.weather_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.sharedViewModel = sharedViewModel
        binding.executePendingBindings()

        sharedViewModel.city.observe(viewLifecycleOwner, cityObserver)


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        sharedViewModel.city.removeObserver(cityObserver)
    }

}