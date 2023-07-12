package com.safronov.spacex_rockets.app

import android.app.Application
import com.safronov.spacex_rockets.di.dataDi
import com.safronov.spacex_rockets.di.domainDi
import com.safronov.spacex_rockets.di.presentationDi
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App(): Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(presentationDi, domainDi, dataDi))
        }
    }

}