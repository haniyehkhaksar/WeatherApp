package io.github.haniyehkhaksar.weatherapp

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.github.haniyehkhaksar.weatherapp.di.AppComponent
import io.github.haniyehkhaksar.weatherapp.di.DaggerAppComponent
import io.github.haniyehkhaksar.weatherapp.di.NetworkModule
import javax.inject.Inject

open class WeatherApp : DaggerApplication() {

    @Inject
    lateinit var appComponent: AppComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = createAppComponent()
        appComponent.inject(this)
        return appComponent
    }

    open fun createAppComponent(): AppComponent {
        return DaggerAppComponent
            .builder()
            .networkModule(NetworkModule())
            .build()
    }

}