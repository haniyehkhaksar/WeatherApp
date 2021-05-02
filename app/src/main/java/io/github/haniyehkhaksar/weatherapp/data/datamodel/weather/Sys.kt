package io.github.haniyehkhaksar.weatherapp.data.datamodel.weather

data class Sys(
    val country: String,
    val id: Int,
    val sunrise: Int,
    val sunset: Int,
    val type: Int,
    val pod: String
)