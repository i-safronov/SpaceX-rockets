package com.safronov.domain.repository

import com.safronov.domain.model.rocket.ListOfRockets
import com.safronov.domain.model.rocket_launch.RocketLaunches


interface RocketRepositoryInt {

    suspend fun getListOfRockets(): ListOfRockets?
    suspend fun getRocketLaunches(rocketId: String): RocketLaunches?

}