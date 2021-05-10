package io.github.haniyehkhaksar.weatherapp.data.datamodel.weather

import io.github.haniyehkhaksar.weatherapp.data.datamodel.TempUtils
import io.github.haniyehkhaksar.weatherapp.domain.domainmodel.WeatherDomainModel

data class Info(
    val clouds: Clouds,
    val dt: Int,
    val dt_txt: String,
    val main: Main,
    val pop: Double,
    val rain: Rain,
    val snow: Snow,
    val sys: Sys,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)

fun Info.toDomainModel(city: String): WeatherDomainModel {

    return WeatherDomainModel(
        city = city,
        currentTemp = TempUtils.kelvinToCelsius(this.main.temp),
        maxTemp = TempUtils.kelvinToCelsius(this.main.temp_max),
        minTemp = TempUtils.kelvinToCelsius(this.main.temp_min),
        icon = "http://openweathermap.org/img/w/${this.weather[0].icon}.png"
    )
}