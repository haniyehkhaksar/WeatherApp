package io.github.haniyehkhaksar.weatherapp.di

import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import io.github.haniyehkhaksar.weatherapp.WeatherApp

@Module
class AppModule {

    @Provides
    fun provideContext(app: WeatherApp): Context = app.applicationContext

    @Provides
    fun provideResources(context: Context): Resources = context.resources
}