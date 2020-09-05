package br.com.vlabs.wiimmfiapp.di

import br.com.vlabs.wiimmfiapp.game.stats.GameStatsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { GameStatsViewModel() }
}

val appModules = listOf(
    viewModelModule
)