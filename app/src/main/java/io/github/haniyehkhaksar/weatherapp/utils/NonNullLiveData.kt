package io.github.haniyehkhaksar.weatherapp.utils

import androidx.lifecycle.MutableLiveData

class NonNullLiveData<T : Any>(defaultValue: T) : MutableLiveData<T>() {
    init {
        value = defaultValue
    }

    override fun getValue(): T {
        return super.getValue()!!
    }

    @SuppressWarnings
    override fun setValue(value: T) {
        super.setValue(value)
    }

    @SuppressWarnings
    override fun postValue(value: T) {
        super.postValue(value)
    }
}