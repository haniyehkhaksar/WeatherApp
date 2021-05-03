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

    lateinit var dataBinding: WeatherFragmentBinding

    // When we have a rotation, our activity call onCreate and then observers as well.
    // because my observers call api, you may think my viewmodel and livedata doesn't work.
    // but it works properly, becuase it catch city name form livedata even after rotation.
    private val cityObserver = Observer<String> { city ->
        if (city.isNullOrEmpty() || city.isNullOrBlank()) {
            dataBinding.root.visibility = View.GONE
        } else {
            dataBinding.root.visibility = View.VISIBLE
            viewModel.getCurrentWeather(city)
            viewModel.getFutureWeather(city)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.weather_fragment, container, false)
        dataBinding.lifecycleOwner = viewLifecycleOwner
        dataBinding.viewModel = viewModel
        dataBinding.sharedViewModel = sharedViewModel
        dataBinding.executePendingBindings()

        sharedViewModel.city.observe(viewLifecycleOwner, cityObserver)


        return dataBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        sharedViewModel.city.removeObserver(cityObserver)
    }

}