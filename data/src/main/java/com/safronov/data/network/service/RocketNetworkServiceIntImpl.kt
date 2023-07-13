package com.safronov.data.network.service

import com.safronov.data.network.api.RocketNetworkApiInt
import com.safronov.domain.model.rocket.ListOfRockets
import retrofit2.Response

class RocketNetworkServiceIntImpl(
    private val rocketNetworkApiInt: RocketNetworkApiInt
): RocketNetworkServiceInt {

    override suspend fun getListOfRockets(): Response<ListOfRockets> {
        return rocketNetworkApiInt.getListOfRockets()
    }

}