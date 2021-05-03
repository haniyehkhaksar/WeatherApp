package io.github.haniyehkhaksar.weatherapp.utils

import android.content.Context
import androidx.preference.PreferenceManager

object SharedPrefUtils {

    @Suppress("UNCHECKED_CAST")
    fun <T> loadPref(context: Context, key: String, defaultValue: T): T {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return when (defaultValue) {
            is Boolean -> {
                prefs.getBoolean(key, defaultValue as Boolean) as T
            }
            is Float -> {
                prefs.getFloat(key, defaultValue as Float) as T
            }
            is Int -> {
                prefs.getInt(key, defaultValue as Int) as T
            }
            is Long -> {
                prefs.getLong(key, defaultValue as Long) as T
            }
            is String -> {
                prefs.getString(key, defaultValue as String) as T
            }
            is Set<*> -> {
                prefs.getStringSet(key, defaultValue as Set<String>) as T
            }
            else -> {
                prefs.getString(key, "") as T
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> savePref(context: Context, key: String, value: T) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = prefs.edit()
        when (value) {
            is Boolean -> {
                editor.putBoolean(key, value as Boolean)
            }
            is Float -> {
                editor.putFloat(key, value as Float)
            }
            is Int -> {
                editor.putInt(key, value as Int)
            }
            is Long -> {
                editor.putLong(key, value as Long)
            }
            is String -> {
                editor.putString(key, value as String)
            }
            is Set<*> -> {
                editor.putStringSet(key, value as Set<String>)
            }
            else -> {
                editor.putString(key, value as String)
            }
        }
        editor.apply()
    }

    fun clear(context: Context) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = prefs.edit()
        editor.clear()
        editor.apply()
    }
}