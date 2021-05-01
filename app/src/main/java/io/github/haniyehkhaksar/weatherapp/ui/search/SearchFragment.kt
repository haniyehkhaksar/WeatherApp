package io.github.haniyehkhaksar.weatherapp.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import dagger.android.support.DaggerFragment
import io.github.haniyehkhaksar.weatherapp.R
import io.github.haniyehkhaksar.weatherapp.databinding.SearchFragmentBinding


class SearchFragment : DaggerFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: SearchFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.search_fragment, container, false)
//        viewDataBinding.setVariable("shared", sharedViewModel)
//        viewDataBinding.setVariable("viewModel", viewModel)
        binding.executePendingBindings()
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

}