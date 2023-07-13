package com.safronov.domain.repository

import com.safronov.domain.model.rocket.ListOfRockets


interface RocketRepositoryInt {

    suspend fun getListOfRockets(): ListOfRockets?

}