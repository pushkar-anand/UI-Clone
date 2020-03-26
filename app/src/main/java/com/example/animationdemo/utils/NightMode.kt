package com.example.animationdemo.utils

import androidx.appcompat.app.AppCompatDelegate

/**
 * This enum class holds values for changing qualifying resources to night mode
 * and used across all activities.
 */
enum class NightMode(val value: Int) {

    AUTO(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY),
    ON(AppCompatDelegate.MODE_NIGHT_YES),
    OFF(AppCompatDelegate.MODE_NIGHT_NO)

}