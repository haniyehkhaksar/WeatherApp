package io.github.haniyehkhaksar.weatherapp.ui.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import dagger.android.support.DaggerFragment
import io.github.haniyehkhaksar.weatherapp.R
import io.github.haniyehkhaksar.weatherapp.databinding.WeatherFragmentBinding
import io.github.haniyehkhaksar.weatherapp.ui.SharedViewModel

class WeatherFragment : DaggerFragment() {

    private lateinit var viewModel: WeatherViewModel
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: WeatherFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.weather_fragment, container, false)
//        viewDataBinding.setVariable("viewModel", viewModel)
//        viewDataBinding.setVariable("shared", sharedViewModel)
//        viewDataBinding.executePendingBindings()
//        viewDataBinding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

}