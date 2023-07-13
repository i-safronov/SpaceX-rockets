package com.safronov.data.network.api

import com.safronov.domain.model.rocket.ListOfRockets
import retrofit2.Response
import retrofit2.http.GET

interface RocketNetworkApiInt {

    @GET("/v4/rockets")
    suspend fun getListOfRockets(): Response<ListOfRockets>

}