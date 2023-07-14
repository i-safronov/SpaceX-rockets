package com.safronov.spacex_rockets.domain.repository

import com.google.gson.annotations.Until
import com.safronov.data.repository.RocketSettingsRepositoryIntImpl
import com.safronov.data.storage.RocketSettingsSharedPreferencesInt
import com.safronov.domain.model.UnitOfMeasurementRocketDiameter
import com.safronov.domain.model.UnitOfMeasurementRocketHeight
import com.safronov.domain.model.UnitOfMeasurementRocketMass
import com.safronov.domain.model.UnitOfMeasurementRocketPayload
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.anyOrNull
import org.mockito.kotlin.mock

class RocketSettingsRepositoryIntImplTest {

    @Test
    fun saveTypeRocketHeightMeasurement() = runBlocking {
        val unitOfMeasurement = UnitOfMeasurementRocketHeight.FT
        val rocketSettingsSharedPreferencesInt = mock<RocketSettingsSharedPreferencesInt>()
        Mockito.`when`(rocketSettingsSharedPreferencesInt.saveTypeRocketHeightMeasurement(anyOrNull())).thenReturn(Unit)
        Mockito.`when`(rocketSettingsSharedPreferencesInt.getTypeRocketHeightMeasurement()).thenReturn(unitOfMeasurement.toString())

        val rocketSettingsRepositoryInt = RocketSettingsRepositoryIntImpl(rocketSettingsSharedPreferencesInt = rocketSettingsSharedPreferencesInt)
        rocketSettingsRepositoryInt.saveTypeRocketHeightMeasurement(unitOfMeasurement = unitOfMeasurement)
        val result = rocketSettingsRepositoryInt.getTypeRocketHeightMeasurement()
        Assert.assertTrue(unitOfMeasurement.toString() == result)
    }

    @Test
    fun saveTypeRocketDiameterMeasurement() = runBlocking {
        val unitOfMeasurement = UnitOfMeasurementRocketDiameter.FT
        val rocketSettingsSharedPreferencesInt = mock<RocketSettingsSharedPreferencesInt>()
        Mockito.`when`(rocketSettingsSharedPreferencesInt.saveTypeRocketDiameterMeasurement(anyOrNull())).thenReturn(Unit)
        Mockito.`when`(rocketSettingsSharedPreferencesInt.getTypeRocketDiameterMeasurement()).thenReturn(unitOfMeasurement.toString())

        val rocketSettingsRepositoryInt = RocketSettingsRepositoryIntImpl(rocketSettingsSharedPreferencesInt = rocketSettingsSharedPreferencesInt)
        rocketSettingsRepositoryInt.saveTypeRocketDiameterMeasurement(unitOfMeasurement)
        val result = rocketSettingsRepositoryInt.getTypeRocketDiameterMeasurement()
        Assert.assertTrue(unitOfMeasurement.toString() == result)
    }

    @Test
    fun saveTypeRocketMassMeasurement() = runBlocking {
        val unitOfMeasurement = UnitOfMeasurementRocketMass.KG
        val rocketSettingsSharedPreferencesInt = mock<RocketSettingsSharedPreferencesInt>()
        Mockito.`when`(rocketSettingsSharedPreferencesInt.saveTypeRocketMassMeasurement(anyOrNull())).thenReturn(Unit)
        Mockito.`when`(rocketSettingsSharedPreferencesInt.getTypeRocketMassMeasurement()).thenReturn(unitOfMeasurement.toString())

        val rocketSettingsRepositoryInt = RocketSettingsRepositoryIntImpl(rocketSettingsSharedPreferencesInt = rocketSettingsSharedPreferencesInt)
        rocketSettingsRepositoryInt.saveTypeRocketMassMeasurement(unitOfMeasurement)
        val result = rocketSettingsRepositoryInt.getTypeRocketMassMeasurement()
        Assert.assertTrue(unitOfMeasurement.toString() == result)
    }

    @Test
    fun saveTypeRocketPayloadMeasurement() = runBlocking {
        val unitOfMeasurement = UnitOfMeasurementRocketPayload.KG
        val rocketSettingsSharedPreferencesInt = mock<RocketSettingsSharedPreferencesInt>()
        Mockito.`when`(rocketSettingsSharedPreferencesInt.saveTypeRocketPayloadMeasurement(anyOrNull())).thenReturn(Unit)
        Mockito.`when`(rocketSettingsSharedPreferencesInt.getTypeRocketPayloadMeasurement()).thenReturn(unitOfMeasurement.toString())

        val rocketSettingsRepositoryInt = RocketSettingsRepositoryIntImpl(rocketSettingsSharedPreferencesInt = rocketSettingsSharedPreferencesInt)
        rocketSettingsRepositoryInt.saveTypeRocketPayloadMeasurement(unitOfMeasurement)
        val result = rocketSettingsRepositoryInt.getTypeRocketPayloadMeasurement()
        Assert.assertTrue(unitOfMeasurement.toString() == result)
    }

}