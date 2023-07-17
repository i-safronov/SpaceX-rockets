package com.safronov.data.network.service

import com.safronov.domain.model.rocket.ListOfRockets
import com.safronov.domain.model.rocket_launch.RocketLaunches
import retrofit2.Response

interface RocketNetworkServiceInt {

    suspend fun getListOfRockets(): Response<ListOfRockets>
    suspend fun getRocketLaunches(rocketId: String): Response<RocketLaunches>

}