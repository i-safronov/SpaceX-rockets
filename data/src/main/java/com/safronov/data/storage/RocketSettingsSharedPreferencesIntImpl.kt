package com.safronov.data.storage

import android.content.SharedPreferences
import com.safronov.domain.model.*

private const val TYPE_ROCKET_HEIGHT_MEASUREMENT = "TypeRocketHeightMeasurement"
private const val TYPE_ROCKET_DIAMETER_MEASUREMENT = "TypeRocketDiameterMeasurement"
private const val TYPE_ROCKET_MASS_MEASUREMENT = "TypeRocketMassMeasurement"
private const val TYPE_ROCKET_PAYLOAD_MEASUREMENT = "TypeRocketPayloadMeasurement"
const val NO_DATA_STRING = ""

class RocketSettingsSharedPreferencesIntImpl(
    private val sharedPreferences: SharedPreferences
): RocketSettingsSharedPreferencesInt {

    override suspend fun saveTypeRocketHeightMeasurement(unitOfMeasurement: UnitOfMeasurementRocketHeight) {
        sharedPreferences.edit().putString(TYPE_ROCKET_HEIGHT_MEASUREMENT, unitOfMeasurement.toString()).apply()
    }

    override suspend fun saveTypeRocketDiameterMeasurement(unitOfMeasurement: UnitOfMeasurementRocketDiameter) {
        sharedPreferences.edit().putString(TYPE_ROCKET_DIAMETER_MEASUREMENT, unitOfMeasurement.toString()).apply()
    }

    override suspend fun saveTypeRocketMassMeasurement(unitOfMeasurement: UnitOfMeasurementRocketMass) {
        sharedPreferences.edit().putString(TYPE_ROCKET_MASS_MEASUREMENT, unitOfMeasurement.toString()).apply()
    }

    override suspend fun saveTypeRocketPayloadMeasurement(unitOfMeasurement: UnitOfMeasurementRocketPayload) {
        sharedPreferences.edit().putString(TYPE_ROCKET_PAYLOAD_MEASUREMENT, unitOfMeasurement.toString()).apply()
    }

    override suspend fun getTypeRocketPayloadMeasurement(): String {
        return sharedPreferences.getString(TYPE_ROCKET_PAYLOAD_MEASUREMENT, NO_DATA_STRING).toString()
    }

    override suspend fun getTypeRocketHeightMeasurement(): String {
       return sharedPreferences.getString(TYPE_ROCKET_HEIGHT_MEASUREMENT, NO_DATA_STRING).toString()
    }

    override suspend fun getTypeRocketDiameterMeasurement(): String {
        return sharedPreferences.getString(TYPE_ROCKET_DIAMETER_MEASUREMENT, NO_DATA_STRING).toString()
    }

    override suspend fun getTypeRocketMassMeasurement(): String {
        return sharedPreferences.getString(TYPE_ROCKET_MASS_MEASUREMENT, NO_DATA_STRING).toString()
    }

    companion object {
        const val ROCKET_SETTINGS_SHARED_PREFERENCES = "Rocket settings shared preferences"
    }

}