package io.github.haniyehkhaksar.weatherapp.ui.main

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import io.github.haniyehkhaksar.weatherapp.R

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}