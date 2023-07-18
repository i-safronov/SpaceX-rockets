package com.safronov.spacex_rockets.presentation.fragment.home_page.rocket_launches

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.safronov.domain.model.rocket_launch.RocketLaunch
import com.safronov.domain.repository.RocketRepositoryInt
import com.safronov.spacex_rockets.core.extension.logE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FragmentRocketLaunchesViewModel(
    private val rocketRepositoryInt: RocketRepositoryInt
): ViewModel() {

    private val _rocketLaunches = MutableStateFlow<List<RocketLaunch>?>(null)
    val rocketLaunches get() = _rocketLaunches.asStateFlow()

    fun loadRocketLaunches(rocketId: String, noLaunches: () -> Unit) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                val allRocketLaunches = rocketRepositoryInt.getRocketLaunches(rocketId = rocketId)
                val rocketLaunchesMutableList = mutableListOf<RocketLaunch>()
                allRocketLaunches?.forEach {
                    if (it.rocket == rocketId) {
                        rocketLaunchesMutableList.add(it)
                    }
                }
                if (allRocketLaunches?.isEmpty() == true) {
                    noLaunches.invoke()
                } else {
                    _rocketLaunches.value = rocketLaunchesMutableList.toList()
                }
            }
        } catch (e: Exception) {
            logE("${this.javaClass.name} -> ${object {}.javaClass.enclosingMethod?.name}, ${e.message}")
        }
    }

}