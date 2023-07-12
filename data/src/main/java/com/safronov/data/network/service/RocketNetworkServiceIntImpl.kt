package com.safronov.data.network.service

import com.safronov.data.network.api.RocketNetworkApiInt
import com.safronov.domain.model.rocket.ListOfRocket
import com.safronov.spacex_rockets.core.extension.logE
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import kotlin.math.log

class RocketNetworkServiceIntImpl(
    private val rocketNetworkApiInt: RocketNetworkApiInt
): RocketNetworkServiceInt {

    override suspend fun getListOfRockets(): Response<ListOfRocket> {
        return rocketNetworkApiInt.getListOfRockets()
    }

}