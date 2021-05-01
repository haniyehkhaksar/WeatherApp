package io.github.haniyehkhaksar.weatherapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.haniyehkhaksar.weatherapp.ui.news.NewsFragment
import io.github.haniyehkhaksar.weatherapp.ui.search.SearchFragment
import io.github.haniyehkhaksar.weatherapp.ui.weather.WeatherFragment


@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector
    abstract fun provideNewsFragment(): NewsFragment

    @ContributesAndroidInjector
    abstract fun provideSearchFragment(): SearchFragment


    @ContributesAndroidInjector
    abstract fun provideWeatherFragment(): WeatherFragment
}