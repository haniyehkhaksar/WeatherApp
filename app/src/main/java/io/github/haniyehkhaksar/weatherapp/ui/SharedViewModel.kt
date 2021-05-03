package io.github.haniyehkhaksar.weatherapp.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import io.github.haniyehkhaksar.weatherapp.utils.NonNullLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedViewModel @Inject constructor() : ViewModel() {

    val city: NonNullLiveData<String> = NonNullLiveData("")

    override fun onCleared() {
        super.onCleared()
        Log.e("Haniiii", "shared-onCleared")
    }
}