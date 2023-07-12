package com.safronov.data.network.service

import com.safronov.domain.model.rocket.ListOfRocket
import retrofit2.Response

interface RocketNetworkServiceInt {

    suspend fun getListOfRockets(): Response<ListOfRocket>

}