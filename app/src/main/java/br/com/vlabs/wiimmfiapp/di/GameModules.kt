package br.com.vlabs.wiimmfiapp.di

import androidx.navigation.NavController
import br.com.vlabs.data.repository.WiimmfiRepository
import br.com.vlabs.domain.repository.GameRepository
import br.com.vlabs.wiimmfiapp.game.detail.GameDetailActivityArgs
import br.com.vlabs.wiimmfiapp.game.detail.GameDetailViewModel
import br.com.vlabs.wiimmfiapp.game.stats.GameStatsViewModel
import br.com.vlabs.wiimmfiapp.router.GameRouter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val repositoryModule = module {
    single<GameRepository> { WiimmfiRepository() }
}

val routerModule = module {
    single { (navController: NavController) -> GameRouter(navController) }
}

val viewModelModule = module {
    viewModel { (args: GameDetailActivityArgs) ->
        GameDetailViewModel(args, get())
    }
    viewModel { (navController: NavController) ->
        GameStatsViewModel(get(), get { parametersOf(navController)})
    }
}

val appModules = listOf(
    repositoryModule,
    routerModule,
    viewModelModule
)