package io.github.haniyehkhaksar.weatherapp.ui

import androidx.lifecycle.ViewModel
import io.github.haniyehkhaksar.weatherapp.utils.NonNullLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedViewModel @Inject constructor() : ViewModel() {

    val city: NonNullLiveData<String> = NonNullLiveData("")
}