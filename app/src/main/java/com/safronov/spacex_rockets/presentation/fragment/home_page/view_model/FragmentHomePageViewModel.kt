package com.safronov.spacex_rockets.presentation.fragment.home_page.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.safronov.domain.model.rocket.ListOfRockets
import com.safronov.domain.repository.RocketRepositoryInt
import com.safronov.spacex_rockets.core.extension.logE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FragmentHomePageViewModel(
    private val rocketRepositoryInt: RocketRepositoryInt
): ViewModel() {

    private val _listOfRockets = MutableStateFlow<ListOfRockets?>(null)
    val listOfRocket = _listOfRockets.asStateFlow()

    fun loadListOfRockets() {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                _listOfRockets.value = rocketRepositoryInt.getListOfRockets()
            }
        } catch (e: Exception) {
            logE("${this.javaClass.name} -> ${object{}.javaClass.enclosingMethod?.name}, ${e.message}")
        }
    }

}