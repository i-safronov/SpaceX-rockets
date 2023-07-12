package com.safronov.spacex_rockets.di

import com.safronov.spacex_rockets.presentation.fragment.home_page.view_model.FragmentHomePageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationDi = module {

    viewModel<FragmentHomePageViewModel> {
        FragmentHomePageViewModel(
            rocketRepositoryInt = get()
        )
    }

}