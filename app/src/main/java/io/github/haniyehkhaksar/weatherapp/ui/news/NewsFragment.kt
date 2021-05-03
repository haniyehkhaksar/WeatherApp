package io.github.haniyehkhaksar.weatherapp.ui.news

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import dagger.android.support.DaggerFragment
import io.github.haniyehkhaksar.weatherapp.R
import io.github.haniyehkhaksar.weatherapp.databinding.NewsFragmentBinding
import io.github.haniyehkhaksar.weatherapp.ui.SharedViewModel
import javax.inject.Inject

class NewsFragment : DaggerFragment() {

    @Inject
    lateinit var viewModel: NewsViewModel

    @Inject
    lateinit var sharedViewModel: SharedViewModel

    lateinit var dataBinding: NewsFragmentBinding

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
                viewModel.getNews(city)
            }
        } else isRotated = false
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.news_fragment, container, false)
        dataBinding.executePendingBindings()
        dataBinding.lifecycleOwner = viewLifecycleOwner
        dataBinding.viewModel = viewModel
        dataBinding.sharedViewModel = sharedViewModel

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