package com.safronov.domain.repository

import com.safronov.domain.model.rocket.ListOfRocket


interface RocketRepositoryInt {

    suspend fun getListOfRockets(): ListOfRocket?

}