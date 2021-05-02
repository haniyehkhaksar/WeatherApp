package io.github.haniyehkhaksar.weatherapp.data.repository

import io.github.haniyehkhaksar.weatherapp.data.datamodel.news.toDomainModel
import io.github.haniyehkhaksar.weatherapp.data.network.NewsApi
import io.github.haniyehkhaksar.weatherapp.domain.repository.INewsRepository
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsApi: NewsApi) : INewsRepository {

    override suspend fun getNews(city: String, count: Int, page: Int) =
        newsApi.getNews(city, count, page).articles.map { it.toDomainModel() }
}