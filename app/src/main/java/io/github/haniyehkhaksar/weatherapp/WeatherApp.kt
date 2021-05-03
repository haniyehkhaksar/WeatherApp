package io.github.haniyehkhaksar.weatherapp

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import io.github.haniyehkhaksar.weatherapp.di.AppComponent
import io.github.haniyehkhaksar.weatherapp.di.DaggerAppComponent
import io.github.haniyehkhaksar.weatherapp.di.HasAppComponent
import javax.inject.Inject

open class WeatherApp : Application(), HasActivityInjector, HasSupportFragmentInjector,
    HasAppComponent {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    final override lateinit var appComponent: AppComponent
        private set

    protected open fun createAppComponent(): AppComponent =
        DaggerAppComponent.builder().application(this).build()

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector
    override fun supportFragmentInjector(): AndroidInjector<Fragment> =
        fragmentDispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()

        appComponent = createAppComponent()
        appComponent.inject(this)
    }

}