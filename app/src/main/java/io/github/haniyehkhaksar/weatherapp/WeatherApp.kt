package io.github.haniyehkhaksar.weatherapp

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.github.haniyehkhaksar.weatherapp.di.AppComponent
import io.github.haniyehkhaksar.weatherapp.di.DaggerAppComponent
import io.github.haniyehkhaksar.weatherapp.di.NetworkModule
import javax.inject.Inject

class WeatherApp : DaggerApplication() {

    @Inject
    lateinit var appComponent: AppComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerAppComponent
            .builder()
            .networkModule(NetworkModule(this))
            .build()
        appComponent.inject(this)
        return appComponent
    }

}