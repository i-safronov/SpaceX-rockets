package com.safronov.data.repository

import com.safronov.data.storage.RocketSettingsSharedPreferencesInt
import com.safronov.domain.model.*
import com.safronov.domain.repository.RocketSettingsRepositoryInt
import com.safronov.spacex_rockets.core.extension.logE

class RocketSettingsRepositoryIntImpl(
    private val rocketSettingsSharedPreferencesInt: RocketSettingsSharedPreferencesInt
): RocketSettingsRepositoryInt {

    override suspend fun saveTypeRocketHeightMeasurement(unitOfMeasurement: UnitOfMeasurementRocketHeight) {
        try {
            rocketSettingsSharedPreferencesInt.saveTypeRocketHeightMeasurement(unitOfMeasurement)
        } catch (e: Exception) {
            logE("Error when saving type rocket height measurement, ${e.message}")
        }
    }

    override suspend fun saveTypeRocketDiameterMeasurement(unitOfMeasurement: UnitOfMeasurementRocketDiameter) {
        try {
            rocketSettingsSharedPreferencesInt.saveTypeRocketDiameterMeasurement(unitOfMeasurement)
        } catch (e: Exception) {
            logE("Error when saving type rocket diameter measurement, ${e.message}")
        }
    }

    override suspend fun saveTypeRocketMassMeasurement(unitOfMeasurement: UnitOfMeasurementRocketMass) {
        try {
            rocketSettingsSharedPreferencesInt.saveTypeRocketMassMeasurement(unitOfMeasurement)
        } catch (e: Exception) {
            logE("Error when saving type rocket mass measurement, ${e.message}")
        }
    }

    override suspend fun saveTypeRocketPayloadMeasurement(unitOfMeasurement: UnitOfMeasurementRocketPayload) {
        try {
            rocketSettingsSharedPreferencesInt.saveTypeRocketPayloadMeasurement(unitOfMeasurement)
        } catch (e: Exception) {
            logE("Error when saving type rocket payload measurement, ${e.message}")
        }
    }

    override suspend fun getTypeRocketPayloadMeasurement(): String {
        try {
            return rocketSettingsSharedPreferencesInt.getTypeRocketPayloadMeasurement()
        } catch (e: Exception) {
            logE("Error when getting type rocket payload measurement, ${e.message}")
            return ""
        }
    }

    override suspend fun getTypeRocketHeightMeasurement(): String {
        try {
            return rocketSettingsSharedPreferencesInt.getTypeRocketHeightMeasurement()
        } catch (e: Exception) {
            logE("Error when getting type rocket height measurement, ${e.message}")
            return ""
        }
    }

    override suspend fun getTypeRocketDiameterMeasurement(): String {
        try {
            return rocketSettingsSharedPreferencesInt.getTypeRocketDiameterMeasurement()
        } catch (e: Exception) {
            logE("Error when getting rocket diameter measurement, ${e.message}")
            return ""
        }
    }

    override suspend fun getTypeRocketMassMeasurement(): String {
        try {
            return rocketSettingsSharedPreferencesInt.getTypeRocketMassMeasurement()
        } catch (e: Exception) {
            logE("Error when getting type rocket mass measurement, ${e.message}")
            return ""
        }
    }

}