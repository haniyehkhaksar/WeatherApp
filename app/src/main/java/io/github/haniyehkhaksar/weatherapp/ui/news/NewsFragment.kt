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

    lateinit var dataBinding: NewsFragmentBinding

    private val cityObserver = Observer<String> { city ->
        if (city.isNullOrEmpty() || city.isNullOrBlank()) {
            dataBinding.root.visibility = View.GONE
        } else {
            dataBinding.root.visibility = View.VISIBLE
            viewModel.getNews(city)
        }
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

}