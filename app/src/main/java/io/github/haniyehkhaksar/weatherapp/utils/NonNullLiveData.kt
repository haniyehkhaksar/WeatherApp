package io.github.haniyehkhaksar.weatherapp.utils

import androidx.lifecycle.MediatorLiveData

class NonNullLiveData<T : Any>(defaultValue: T) : MediatorLiveData<T>() {
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