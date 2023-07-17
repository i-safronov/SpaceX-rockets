package com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_launches

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.safronov.domain.model.rocket_launch.RocketLaunches
import com.safronov.domain.repository.RocketRepositoryInt
import com.safronov.spacex_rockets.core.extension.logE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FragmentRocketLaunchesViewModel(
    private val rocketRepositoryInt: RocketRepositoryInt
): ViewModel() {

    private val _rocketLaunches = MutableStateFlow<RocketLaunches?>(null)
    val rocketLaunches get() = _rocketLaunches.asStateFlow()

    fun getRocketLaunches(rocketId: String) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                _rocketLaunches.value = rocketRepositoryInt.getRocketLaunches(rocketId = rocketId)
            }
        } catch (e: Exception) {
            logE("${this.javaClass.name} -> ${object {}.javaClass.enclosingMethod?.name}, ${e.message}")
        }
    }

}