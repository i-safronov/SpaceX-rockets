package com.safronov.spacex_rockets.di

import com.safronov.data.network.api.RocketNetworkApiInt
import com.safronov.data.repository.RocketRepositoryIntImpl
import com.safronov.domain.repository.RocketRepositoryInt
import org.koin.dsl.module

val domainDi = module {

    factory<RocketRepositoryInt> {
        RocketRepositoryIntImpl(
            rocketNetworkServiceInt = get()
        )
    }

}