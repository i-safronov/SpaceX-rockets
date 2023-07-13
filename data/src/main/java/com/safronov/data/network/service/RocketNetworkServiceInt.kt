package com.safronov.data.network.service

import com.safronov.domain.model.rocket.ListOfRockets
import retrofit2.Response

interface RocketNetworkServiceInt {

    suspend fun getListOfRockets(): Response<ListOfRockets>

}