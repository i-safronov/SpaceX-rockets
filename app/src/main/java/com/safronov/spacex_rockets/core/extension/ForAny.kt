package com.safronov.spacex_rockets.core.extension

import android.util.Log

const val TAG = "MyLog"

fun Any.logE(msg: String) {
    Log.e(TAG, msg)
}