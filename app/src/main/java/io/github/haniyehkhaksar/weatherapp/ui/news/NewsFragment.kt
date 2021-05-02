package io.github.haniyehkhaksar.weatherapp.ui.news

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

    private val cityObserver = Observer<String> { city -> viewModel.getNews(city) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: NewsFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.news_fragment, container, false)
        binding.executePendingBindings()
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.sharedViewModel = sharedViewModel

        sharedViewModel.city.observe(viewLifecycleOwner, cityObserver)

        return binding.root
    }

}