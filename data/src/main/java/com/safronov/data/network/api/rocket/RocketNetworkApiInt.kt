package com.safronov.data.network.api.rocket

import com.safronov.domain.model.rocket.ListOfRockets
import com.safronov.domain.model.rocket_launch.RocketLaunches
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RocketNetworkApiInt {

    @GET("/v4/rockets")
    suspend fun getListOfRockets(): Response<ListOfRockets>

    @GET("/v4/launches")
    suspend fun getRocketLaunches(
        @Query("rocket_id") rocketId: String
    ): Response<RocketLaunches>

}