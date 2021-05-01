package io.github.haniyehkhaksar.weatherapp.ui.base.extension

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.toLiveData() = this as LiveData<T>
