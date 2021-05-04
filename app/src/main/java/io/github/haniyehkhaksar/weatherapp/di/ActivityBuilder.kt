package io.github.haniyehkhaksar.weatherapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.haniyehkhaksar.weatherapp.ui.main.MainActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}
