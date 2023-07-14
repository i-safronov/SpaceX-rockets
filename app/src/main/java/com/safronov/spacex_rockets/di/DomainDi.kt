package com.safronov.spacex_rockets.di

import com.safronov.data.network.api.RocketNetworkApiInt
import com.safronov.data.repository.RocketRepositoryIntImpl
import com.safronov.data.repository.RocketSettingsRepositoryIntImpl
import com.safronov.domain.repository.RocketRepositoryInt
import com.safronov.domain.repository.RocketSettingsRepositoryInt
import org.koin.dsl.module

val domainDi = module {

    single<RocketRepositoryInt> {
        RocketRepositoryIntImpl(
            rocketNetworkServiceInt = get()
        )
    }

    single<RocketSettingsRepositoryInt> {
        RocketSettingsRepositoryIntImpl(
            rocketSettingsSharedPreferencesInt = get()
        )
    }

}