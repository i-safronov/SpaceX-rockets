package com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_settings.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.safronov.domain.model.UnitOfMeasurementRocketHeight
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

    fun saveTypeRocketHeightMeasurement(unitOfMeasurement: UnitOfMeasurementRocketHeight) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                rocketSettingsRepositoryInt.saveTypeRocketHeightMeasurement(unitOfMeasurement = unitOfMeasurement)
            }
        } catch (e: Exception) {
            logE("${this.javaClass.name} -> ${object {}.javaClass.enclosingMethod?.name}, ${e.message}")
        }
    }

}