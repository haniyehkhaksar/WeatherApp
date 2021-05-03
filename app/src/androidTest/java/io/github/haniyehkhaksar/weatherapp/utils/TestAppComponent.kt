package io.github.haniyehkhaksar.weatherapp.utils

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import io.github.haniyehkhaksar.weatherapp.di.*
import io.github.haniyehkhaksar.weatherapp.tests.MainTest
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, AppModule::class, ViewModelModule::class,
        NetworkModule::class, ActivityBuilder::class, FragmentBuilder::class]
)
interface TestAppComponent : AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): TestAppComponent
    }

    fun inject(mainTest: MainTest)
}
