package io.github.haniyehkhaksar.weatherapp.data.network

import io.github.haniyehkhaksar.weatherapp.data.datamodel.news.NewsDataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v2/everything")
    suspend fun getNews(
        @Query("q") city: String,
        @Query("pageSize") count: Int,
        @Query("page") page: Int,
        @Query("apiKey") key: String = "9121237e86d144d9bc96ab1af497dd23"
    ): NewsDataModel
}