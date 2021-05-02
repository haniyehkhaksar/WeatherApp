package io.github.haniyehkhaksar.weatherapp.data.datamodel.weather

data class FutureWeatherDataModel(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<Info>,
    val message: Int
)

