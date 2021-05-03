package io.github.haniyehkhaksar.weatherapp.di

import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideResources(context: Context): Resources = context.resources
}