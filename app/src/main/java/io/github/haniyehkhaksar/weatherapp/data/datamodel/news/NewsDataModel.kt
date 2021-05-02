package io.github.haniyehkhaksar.weatherapp.data.datamodel.news

data class NewsDataModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)