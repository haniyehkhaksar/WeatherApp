package io.github.haniyehkhaksar.weatherapp.ui

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.ViewModel
import javax.inject.Inject


class SharedViewModel @Inject constructor() : ViewModel() {

    var searchWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(editable: Editable) {
            //TODO call api
        }
    }
}