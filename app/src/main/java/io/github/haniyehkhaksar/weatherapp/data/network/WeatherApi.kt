package io.github.haniyehkhaksar.weatherapp.data.network

import io.github.haniyehkhaksar.weatherapp.data.datamodel.weather.CurrentWeatherDataModel
import io.github.haniyehkhaksar.weatherapp.data.datamodel.weather.FutureWeatherDataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/weather")
    suspend fun getCurrentWeather(
        @Query("q") city: String,
        @Query("appid") key: String = "9b6dc140fb309700fe32b388dccda280"
    ): CurrentWeatherDataModel

    @GET("data/2.5/forecast")
    suspend fun getFutureWeather(
        @Query("q") city: String,
        @Query("cnt") count: Int,
        @Query("appid") key: String = "9b6dc140fb309700fe32b388dccda280"
    ): FutureWeatherDataModel

}