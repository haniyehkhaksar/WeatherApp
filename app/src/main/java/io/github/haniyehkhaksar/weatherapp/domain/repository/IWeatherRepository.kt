package io.github.haniyehkhaksar.weatherapp.domain.repository

import io.github.haniyehkhaksar.weatherapp.domain.domainmodel.WeatherDomainModel

interface IWeatherRepository {

    suspend fun getCurrentWeather(city: String): WeatherDomainModel

    suspend fun getFutureWeather(city: String, count: Int): List<WeatherDomainModel>
}