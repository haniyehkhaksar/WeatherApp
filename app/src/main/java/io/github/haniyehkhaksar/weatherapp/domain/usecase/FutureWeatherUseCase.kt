package io.github.haniyehkhaksar.weatherapp.domain.usecase

import io.github.haniyehkhaksar.weatherapp.data.repository.WeatherRepository
import io.github.haniyehkhaksar.weatherapp.domain.domainmodel.WeatherDomainModel
import javax.inject.Inject

class FutureWeatherUseCase @Inject constructor(private val weatherRepository: WeatherRepository) {

    //TODO we can add more options like INTERNET_ERROR, SERVER_ERROR, GENERAL_ERROR to handle different errors in a way we like.
    sealed class Result {
        data class Success(val data: List<WeatherDomainModel>) : Result()
        data class Error(val e: Throwable) : Result()
    }

    suspend fun execute(city: String, count: Int): Result {
        return try {
            Result.Success(weatherRepository.getFutureWeather(city, count))
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}