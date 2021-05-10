package io.github.haniyehkhaksar.weatherapp.data.datamodel

object TempUtils {

    fun kelvinToCelsius(kelvin: Double): Double {
        return kelvin - 273.5
    }
}