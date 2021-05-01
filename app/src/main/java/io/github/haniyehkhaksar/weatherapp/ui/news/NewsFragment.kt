package io.github.haniyehkhaksar.weatherapp.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import dagger.android.support.DaggerFragment
import io.github.haniyehkhaksar.weatherapp.R
import io.github.haniyehkhaksar.weatherapp.databinding.NewsFragmentBinding
import io.github.haniyehkhaksar.weatherapp.ui.SharedViewModel

class NewsFragment : DaggerFragment() {

    private lateinit var viewModel: NewsViewModel
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: NewsFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.news_fragment, container, false)
//        viewDataBinding.setVariable("viewModel", viewModel)
//        viewDataBinding.setVariable("shared", sharedViewModel)
//        viewDataBinding.executePendingBindings()
//        viewDataBinding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

}