package com.safronov.spacex_rockets.core.extension

import android.util.Log

const val TAG = "RocketTag"

fun Any.logE(msg: String) {
    Log.e(TAG, msg)
}