package com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_settings.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.safronov.domain.model.UnitOfMeasurementRocketDiameter
import com.safronov.domain.model.UnitOfMeasurementRocketHeight
import com.safronov.domain.model.UnitOfMeasurementRocketMass
import com.safronov.domain.model.UnitOfMeasurementRocketPayload
import com.safronov.domain.repository.RocketSettingsRepositoryInt
import com.safronov.spacex_rockets.core.extension.logE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FragmentRocketSettingsViewModel(
    private val rocketSettingsRepositoryInt: RocketSettingsRepositoryInt
): ViewModel() {

    fun getTypeRocketHeightMeasurement(result: (String) -> Unit) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                result.invoke(rocketSettingsRepositoryInt.getTypeRocketHeightMeasurement())
            }
        } catch (e: Exception) {
            logE("${this.javaClass.name} -> ${object {}.javaClass.enclosingMethod?.name}, ${e.message}")
        }
    }

    fun getTypeRocketDiameterMeasurement(result: (String) -> Unit) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                result.invoke(rocketSettingsRepositoryInt.getTypeRocketDiameterMeasurement())
            }
        } catch (e: Exception) {
            logE("${this.javaClass.name} -> ${object {}.javaClass.enclosingMethod?.name}, ${e.message}")
        }
    }

    fun getTypeRocketMassMeasurement(result: (String) -> Unit) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                result.invoke(rocketSettingsRepositoryInt.getTypeRocketMassMeasurement())
            }
        } catch (e: Exception) {
            logE("${this.javaClass.name} -> ${object {}.javaClass.enclosingMethod?.name}, ${e.message}")
        }
    }

    fun getTypeRocketPayloadMeasurement(result: (String) -> Unit) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                result.invoke(rocketSettingsRepositoryInt.getTypeRocketPayloadMeasurement())
            }
        } catch (e: Exception) {
            logE("${this.javaClass.name} -> ${object {}.javaClass.enclosingMethod?.name}, ${e.message}")
        }
    }

    fun saveTypeRocketHeightMeasurement(unitOfMeasurement: UnitOfMeasurementRocketHeight) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                rocketSettingsRepositoryInt.saveTypeRocketHeightMeasurement(unitOfMeasurement = unitOfMeasurement)
            }
        } catch (e: Exception) {
            logE("${this.javaClass.name} -> ${object {}.javaClass.enclosingMethod?.name}, ${e.message}")
        }
    }

    fun saveTypeRocketDiameterMeasurement(unitOfMeasurement: UnitOfMeasurementRocketDiameter) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                rocketSettingsRepositoryInt.saveTypeRocketDiameterMeasurement(unitOfMeasurement = unitOfMeasurement)
            }
        } catch (e: Exception) {
            logE("${this.javaClass.name} -> ${object {}.javaClass.enclosingMethod?.name}, ${e.message}")
        }
    }

    fun saveTypeRocketMassMeasurement(unitOfMeasurement: UnitOfMeasurementRocketMass) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                rocketSettingsRepositoryInt.saveTypeRocketMassMeasurement(unitOfMeasurement = unitOfMeasurement)
            }
        } catch (e: Exception) {
            logE("${this.javaClass.name} -> ${object {}.javaClass.enclosingMethod?.name}, ${e.message}")
        }
    }

    fun saveTypeRocketPayloadMeasurement(unitOfMeasurement: UnitOfMeasurementRocketPayload) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                rocketSettingsRepositoryInt.saveTypeRocketPayloadMeasurement(unitOfMeasurement = unitOfMeasurement)
            }
        } catch (e: Exception) {
            logE("${this.javaClass.name} -> ${object {}.javaClass.enclosingMethod?.name}, ${e.message}")
        }
    }

}