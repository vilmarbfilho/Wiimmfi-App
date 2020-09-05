package br.com.vlabs.wiimmfiapp.di

import br.com.vlabs.data.repository.WiimmfiRepository
import br.com.vlabs.domain.repository.GameRepository
import br.com.vlabs.wiimmfiapp.game.stats.GameStatsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single<GameRepository> { WiimmfiRepository() }
}

val viewModelModule = module {
    viewModel { GameStatsViewModel(get()) }
}

val appModules = listOf(
    repositoryModule,
    viewModelModule
)