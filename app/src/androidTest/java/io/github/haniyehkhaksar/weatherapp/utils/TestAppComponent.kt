package io.github.haniyehkhaksar.weatherapp.utils

import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import io.github.haniyehkhaksar.weatherapp.di.*
import io.github.haniyehkhaksar.weatherapp.tests.MainTest
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ViewModelModule::class,
        MockNetworkModule::class,
        ActivityBuilder::class,
        FragmentBuilder::class]
)
interface TestAppComponent : AppComponent {

    fun inject(mainTest: MainTest)
}
