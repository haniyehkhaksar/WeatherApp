package io.github.haniyehkhaksar.weatherapp.data.datamodel.news

import io.github.haniyehkhaksar.weatherapp.domain.domainmodel.NewsDomainModel

data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)

fun Article.toDomainModel(): NewsDomainModel {
    return NewsDomainModel(
        title = this.title,
        source = this.source.name,
        image = urlToImage,
        link = url
    )
}