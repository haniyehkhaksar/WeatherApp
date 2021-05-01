package io.github.haniyehkhaksar.weatherapp.di

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import io.github.haniyehkhaksar.weatherapp.WeatherApp
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, AppModule::class, ViewModelModule::class,
        NetworkModule::class, ActivityBuilder::class, FragmentBuilder::class]
)
interface AppComponent : AndroidInjector<WeatherApp>