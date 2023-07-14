package com.safronov.domain.repository

import com.safronov.domain.model.UnitOfMeasurementRocketDiameter
import com.safronov.domain.model.UnitOfMeasurementRocketHeight
import com.safronov.domain.model.UnitOfMeasurementRocketMass
import com.safronov.domain.model.UnitOfMeasurementRocketPayload

interface RocketSettingsRepositoryInt {

    suspend fun saveTypeRocketHeightMeasurement(unitOfMeasurement: UnitOfMeasurementRocketHeight)
    suspend fun saveTypeRocketDiameterMeasurement(unitOfMeasurement: UnitOfMeasurementRocketDiameter)
    suspend fun saveTypeRocketMassMeasurement(unitOfMeasurement: UnitOfMeasurementRocketMass)
    suspend fun saveTypeRocketPayloadMeasurement(unitOfMeasurement: UnitOfMeasurementRocketPayload)

    suspend fun getTypeRocketHeightMeasurement(): String
    suspend fun getTypeRocketDiameterMeasurement(): String
    suspend fun getTypeRocketMassMeasurement(): String
    suspend fun getTypeRocketPayloadMeasurement(): String

}