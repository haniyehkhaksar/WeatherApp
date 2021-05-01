package io.github.haniyehkhaksar.weatherapp.ui.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import dagger.android.support.DaggerAppCompatActivity
import io.github.haniyehkhaksar.weatherapp.R
import io.github.haniyehkhaksar.weatherapp.databinding.ActivityMainBinding

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var databinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}