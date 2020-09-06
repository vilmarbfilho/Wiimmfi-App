package br.com.vlabs.wiimmfiapp.di

import br.com.vlabs.data.repository.WiimmfiRepository
import br.com.vlabs.domain.repository.GameRepository
import br.com.vlabs.wiimmfiapp.game.detail.GameDetailViewModel
import br.com.vlabs.wiimmfiapp.game.stats.GameStatsViewModel
import br.com.vlabs.wiimmfiapp.router.GameRouter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single<GameRepository> { WiimmfiRepository() }
}

val routerModule = module {
    single { GameRouter() }
}

val viewModelModule = module {
    viewModel { GameDetailViewModel() }
    viewModel { GameStatsViewModel(get(), get()) }
}

val appModules = listOf(
    repositoryModule,
    routerModule,
    viewModelModule
)