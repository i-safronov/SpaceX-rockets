package com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_details.view_model

import androidx.lifecycle.ViewModel
import com.safronov.domain.repository.RocketSettingsRepositoryInt

class FragmentRocketDetailsViewModel(
    private val rocketSettingsRepositoryInt: RocketSettingsRepositoryInt
): ViewModel() {

    suspend fun getTypeRocketHeightMeasurement(): String {
       return rocketSettingsRepositoryInt.getTypeRocketHeightMeasurement()
    }

    suspend fun getTypeRocketDiameterMeasurement(): String {
        return rocketSettingsRepositoryInt.getTypeRocketDiameterMeasurement()
    }

    suspend fun getTypeRocketMassMeasurement(): String {
        return rocketSettingsRepositoryInt.getTypeRocketMassMeasurement()
    }

    suspend fun getTypeRocketPayloadMeasurement(): String {
        return rocketSettingsRepositoryInt.getTypeRocketPayloadMeasurement()
    }

}