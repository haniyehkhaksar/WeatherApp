package io.github.haniyehkhaksar.weatherapp.data.repository

import io.github.haniyehkhaksar.weatherapp.data.datamodel.weather.toDomainModel
import io.github.haniyehkhaksar.weatherapp.data.network.WeatherApi
import io.github.haniyehkhaksar.weatherapp.domain.repository.IWeatherRepository
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val weatherApi: WeatherApi) :
    IWeatherRepository {

    override suspend fun getCurrentWeather(city: String) =
        weatherApi.getCurrentWeather(city)
            .toDomainModel()

    override suspend fun getFutureWeather(city: String, count: Int) =
        weatherApi.getFutureWeather(city, count).list.map { it.toDomainModel(city) }

}