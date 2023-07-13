package com.safronov.spacex_rockets.core.extension

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.toastS(msg: String) {
    if (this.context != null) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}