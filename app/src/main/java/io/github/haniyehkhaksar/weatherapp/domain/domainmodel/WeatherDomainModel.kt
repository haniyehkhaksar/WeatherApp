package io.github.haniyehkhaksar.weatherapp.domain.domainmodel


data class WeatherDomainModel(
    val city: String,
    val currentTemp: Double,
    val maxTemp: Double,
    val minTemp: Double,
    val icon: String
)
