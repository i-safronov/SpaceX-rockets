package com.safronov.data.repository

import com.safronov.data.network.service.RocketNetworkServiceInt
import com.safronov.domain.model.rocket.ListOfRockets
import com.safronov.domain.repository.RocketRepositoryInt
import com.safronov.spacex_rockets.core.extension.logE

class RocketRepositoryIntImpl(
    private val rocketNetworkServiceInt: RocketNetworkServiceInt
): RocketRepositoryInt {

    override suspend fun getListOfRockets(): ListOfRockets? {
        try {
            val response = rocketNetworkServiceInt.getListOfRockets()
            if (response.isSuccessful) {
                return response.body()
            } else {
                logE("Received a code with an error from the server, status code: ${response.code()}")
                return null
            }
        } catch (e: Exception) {
            logE("Network exception when getting list of rockets: ${e.message}")
            return null
        }
    }

}