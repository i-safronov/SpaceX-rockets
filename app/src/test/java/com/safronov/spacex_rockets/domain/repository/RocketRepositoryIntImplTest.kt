package com.safronov.spacex_rockets.domain.repository

import com.safronov.data.network.api.RocketNetworkApiInt
import com.safronov.data.network.service.RocketNetworkServiceIntImpl
import com.safronov.data.repository.RocketRepositoryIntImpl
import com.safronov.domain.model.rocket.ListOfRockets
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class RocketRepositoryIntImplTest {

    @Test
    fun getListOfRockets() = runBlocking {
        val rocketNetworkApiInt = mock<RocketNetworkApiInt>()
        Mockito.`when`(rocketNetworkApiInt.getListOfRockets()).thenReturn(retrofit2.Response.success(200, ListOfRockets()))
        val rocketNetworkServiceInt = RocketNetworkServiceIntImpl(rocketNetworkApiInt = rocketNetworkApiInt)
        val rocketRepositoryIntImpl = RocketRepositoryIntImpl(rocketNetworkServiceInt = rocketNetworkServiceInt)
        val result = rocketRepositoryIntImpl.getListOfRockets()
        Assert.assertTrue(result?.isEmpty() == true)
    }

}