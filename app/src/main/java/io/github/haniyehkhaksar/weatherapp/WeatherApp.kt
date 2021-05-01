package io.github.haniyehkhaksar.weatherapp

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.github.haniyehkhaksar.weatherapp.di.AppComponent
import io.github.haniyehkhaksar.weatherapp.di.DaggerAppComponent
import javax.inject.Inject

class WeatherApp : DaggerApplication() {

    @Inject
    lateinit var appComponent: AppComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerAppComponent
            .builder()
            .build()
        appComponent.inject(this)
        return appComponent
    }

}