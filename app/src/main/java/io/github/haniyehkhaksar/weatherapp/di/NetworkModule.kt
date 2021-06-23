package io.github.haniyehkhaksar.weatherapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.haniyehkhaksar.weatherapp.data.network.NewsApi
import io.github.haniyehkhaksar.weatherapp.data.network.WeatherApi
import io.github.haniyehkhaksar.weatherapp.utils.LoggingInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC

        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(LoggingInterceptor())
            .addInterceptor(interceptor)
            .build()
    }

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class WeatherRetrofit

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class NewsRetrofit

    @Provides
    @Singleton
    @WeatherRetrofit
    fun provideWeatherRetrofitInterface(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.openweathermap.org/")
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    @NewsRetrofit
    fun provideNewsRetrofitInterface(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://newsapi.org/")
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideWeatherApi(@WeatherRetrofit retrofit: Retrofit): WeatherApi =
        retrofit.create(WeatherApi::class.java)

    @Provides
    @Singleton
    fun provideNewsApi(@NewsRetrofit retrofit: Retrofit): NewsApi =
        retrofit.create(NewsApi::class.java)

}