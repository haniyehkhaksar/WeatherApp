package io.github.haniyehkhaksar.weatherapp.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.github.haniyehkhaksar.weatherapp.data.network.NewsApi
import io.github.haniyehkhaksar.weatherapp.data.network.WeatherApi
import io.github.haniyehkhaksar.weatherapp.utils.LoggingInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

@Module
class NetworkModule {

    @Provides
    @Reusable
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

    @Provides
    @Reusable
    @Named("WeatherRetrofit")
    fun provideWeatherRetrofitInterface(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl("https://api.openweathermap.org/")
            .client(okHttpClient)
            .build()

    @Provides
    @Reusable
    @Named("NewsRetrofit")
    fun provideNewsRetrofitInterface(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl("https://newsapi.org/")
            .client(okHttpClient)
            .build()

    @Provides
    @Reusable
    fun provideWeatherApi(@Named("WeatherRetrofit") retrofit: Retrofit): WeatherApi =
        retrofit.create(WeatherApi::class.java)

    @Provides
    @Reusable
    fun provideNewsApi(@Named("NewsRetrofit") retrofit: Retrofit): NewsApi =
        retrofit.create(NewsApi::class.java)

}