package io.github.haniyehkhaksar.weatherapp.domain.repository

import io.github.haniyehkhaksar.weatherapp.domain.domainmodel.NewsDomainModel

interface INewsRepository {

    suspend fun getNews(city: String, count: Int, page: Int): List<NewsDomainModel>
}