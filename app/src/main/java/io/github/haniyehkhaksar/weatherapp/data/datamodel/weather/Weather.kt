package io.github.haniyehkhaksar.weatherapp.data.datamodel.weather

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)