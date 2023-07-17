package com.safronov.data.network.service

import com.safronov.data.network.api.rocket.RocketNetworkApiInt
import com.safronov.domain.model.rocket.ListOfRockets
import com.safronov.domain.model.rocket_launch.RocketLaunches
import retrofit2.Response

class RocketNetworkServiceIntImpl(
    private val rocketNetworkApiInt: RocketNetworkApiInt
): RocketNetworkServiceInt {

    override suspend fun getListOfRockets(): Response<ListOfRockets> {
        return rocketNetworkApiInt.getListOfRockets()
    }

    override suspend fun getRocketLaunches(rocketId: String): Response<RocketLaunches> {
        return rocketNetworkApiInt.getRocketLaunches(rocketId = rocketId)
    }

}