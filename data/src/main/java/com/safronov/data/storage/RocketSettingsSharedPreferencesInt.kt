package com.safronov.data.storage

import com.safronov.domain.model.*

interface RocketSettingsSharedPreferencesInt {

    suspend fun saveTypeRocketHeightMeasurement(unitOfMeasurement: UnitOfMeasurementRocketHeight)
    suspend fun saveTypeRocketDiameterMeasurement(unitOfMeasurement: UnitOfMeasurementRocketDiameter)
    suspend fun saveTypeRocketMassMeasurement(unitOfMeasurement: UnitOfMeasurementRocketMass)
    suspend fun saveTypeRocketPayloadMeasurement(unitOfMeasurement: UnitOfMeasurementRocketPayload)

    suspend fun getTypeRocketPayloadMeasurement(): String
    suspend fun getTypeRocketHeightMeasurement(): String
    suspend fun getTypeRocketDiameterMeasurement(): String
    suspend fun getTypeRocketMassMeasurement(): String

}