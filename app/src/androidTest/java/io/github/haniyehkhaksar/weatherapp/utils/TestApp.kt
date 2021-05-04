package io.github.haniyehkhaksar.weatherapp.utils

import io.github.haniyehkhaksar.weatherapp.WeatherApp
import io.github.haniyehkhaksar.weatherapp.di.AppComponent
import io.github.haniyehkhaksar.weatherapp.di.MockNetworkModule

/**
 * The application class used when running the app in instrumented tests.
 *
 * This is activated in [TestRunner].
 */
class TestApp : WeatherApp() {

    override fun createAppComponent(): AppComponent {
        return DaggerTestAppComponent
            .builder()
            .mockNetworkModule(MockNetworkModule())
            .build()
    }

}
