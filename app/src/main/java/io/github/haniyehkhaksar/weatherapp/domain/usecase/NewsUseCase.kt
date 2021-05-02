package io.github.haniyehkhaksar.weatherapp.domain.usecase

import io.github.haniyehkhaksar.weatherapp.data.repository.NewsRepository
import io.github.haniyehkhaksar.weatherapp.domain.domainmodel.NewsDomainModel
import javax.inject.Inject

class NewsUseCase @Inject constructor(private val newsRepository: NewsRepository) {

    sealed class Result {
        data class Success(val data: List<NewsDomainModel>) : Result()
        data class Error(val e: Throwable) : Result()
    }

    suspend fun execute(city: String, count: Int, page: Int): Result {
        return try {
            Result.Success(newsRepository.getNews(city, count, page))
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}