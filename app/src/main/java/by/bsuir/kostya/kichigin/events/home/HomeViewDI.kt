package by.bsuir.kostya.kichigin.events.home

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeViewModelModule = module {
    viewModel { HomeViewModel(repository = get()) }
}