package io.github.haniyehkhaksar.weatherapp.ui.weather

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import io.github.haniyehkhaksar.weatherapp.R
import io.github.haniyehkhaksar.weatherapp.databinding.WeatherFragmentBinding
import io.github.haniyehkhaksar.weatherapp.ui.SharedViewModel

@AndroidEntryPoint
class WeatherFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val viewModel: WeatherViewModel by viewModels()

    lateinit var dataBinding: WeatherFragmentBinding

    private var isRotated = false

    // When we have a rotation, our activity call onCreate and then observers as well.
    // because my observers call api, you may think my viewmodel and livedata doesn't work.
    // but it works properly. for now I just put a flag here if rotation happen api won't be called.
    // it's not the best way to handle, but for now with lack of time it should be ok
    // TODO using a database give us a way to handle losing data if we lost internet connection
    private val cityObserver = Observer<String> { city ->
        if (!isRotated) {
            if (city.isNullOrEmpty() || city.isNullOrBlank()) {
                dataBinding.root.visibility = View.GONE
            } else {
                dataBinding.root.visibility = View.VISIBLE
                viewModel.getCurrentWeather(city)
                viewModel.getFutureWeather(city)
            }
        } else isRotated = false
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

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        isRotated = true
    }

}