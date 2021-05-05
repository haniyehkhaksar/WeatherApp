package io.github.haniyehkhaksar.weatherapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.haniyehkhaksar.weatherapp.utils.NonNullLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainViewModel @Inject constructor() : ViewModel() {

    val showContentLayout: MutableLiveData<Boolean> = NonNullLiveData(false)

    fun setContentVisibility(showContent: Boolean) {
        showContentLayout.value = showContent
    }


}