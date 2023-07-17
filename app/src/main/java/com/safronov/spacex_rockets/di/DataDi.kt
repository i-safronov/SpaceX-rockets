package com.safronov.spacex_rockets.di

import android.content.Context
import com.safronov.data.network.api.rocket.RocketNetworkApiInt
import com.safronov.data.network.api.rocket.RocketNetworkApiIntInfo
import com.safronov.data.network.service.RocketNetworkServiceInt
import com.safronov.data.network.service.RocketNetworkServiceIntImpl
import com.safronov.data.storage.RocketSettingsSharedPreferencesInt
import com.safronov.data.storage.RocketSettingsSharedPreferencesIntImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataDi = module {

    single<RocketNetworkServiceInt> {
        RocketNetworkServiceIntImpl(
            rocketNetworkApiInt = get()
        )
    }

    single<RocketNetworkApiInt> {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder().addNetworkInterceptor(loggingInterceptor).addInterceptor(loggingInterceptor).build()
        val retrofit = Retrofit
            .Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(RocketNetworkApiIntInfo.BASE_URL)
            .build()
        retrofit.create(RocketNetworkApiInt::class.java)
    }

    single<RocketSettingsSharedPreferencesInt> {
        RocketSettingsSharedPreferencesIntImpl(
            sharedPreferences = androidApplication().applicationContext.getSharedPreferences(
                RocketSettingsSharedPreferencesIntImpl.ROCKET_SETTINGS_SHARED_PREFERENCES, Context.MODE_PRIVATE
            )
        )
    }

}