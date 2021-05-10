package io.github.haniyehkhaksar.weatherapp.data.datamodel.weather

import io.github.haniyehkhaksar.weatherapp.data.datamodel.TempUtils
import io.github.haniyehkhaksar.weatherapp.domain.domainmodel.WeatherDomainModel

data class CurrentWeatherDataModel(
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)

fun CurrentWeatherDataModel.toDomainModel(): WeatherDomainModel {

    return WeatherDomainModel(
        this.name,
        TempUtils.kelvinToCelsius(this.main.temp),
        TempUtils.kelvinToCelsius(this.main.temp_max),
        TempUtils.kelvinToCelsius(this.main.temp_min),
        "http://openweathermap.org/img/w/${this.weather[0].icon}.png"
    )
}