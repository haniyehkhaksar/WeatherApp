package io.github.haniyehkhaksar.weatherapp.utils

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner

/**
 * Replaces the application class during instrumented tests and registers idling resources for Espresso.
 *
 * This is configured in build.gradle.
 *
 * Read more about this [here](https://invistaware.atlassian.net/wiki/x/DIDNKQ).
 */
/**
 * Custom runner to disable dependency injection.
 */
class TestRunner : AndroidJUnitRunner() {
    override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
        return super.newApplication(cl, TestApp::class.java.name, context)
    }
}
