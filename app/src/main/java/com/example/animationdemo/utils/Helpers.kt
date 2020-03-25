package com.example.animationdemo.utils

import java.util.concurrent.Executors

private val SINGLE_EXECUTOR = Executors.newSingleThreadExecutor()

fun runInBackground(f: () -> Unit) {
    SINGLE_EXECUTOR.execute(f)
}