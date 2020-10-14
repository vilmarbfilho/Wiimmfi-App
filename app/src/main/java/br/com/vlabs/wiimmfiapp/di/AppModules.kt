package br.com.vlabs.wiimmfiapp.di

import androidx.navigation.NavController
import br.com.vlabs.data.remoteconfig.AppRemoteConfig
import br.com.vlabs.data.repository.WiimmfiRepository
import br.com.vlabs.data.scrap.WiimmfiScraper
import br.com.vlabs.domain.repository.GameRepository
import br.com.vlabs.wiimmfiapp.common.CustomTabHelper
import br.com.vlabs.wiimmfiapp.ui.game.detail.GameDetailActivityArgs
import br.com.vlabs.wiimmfiapp.ui.game.detail.GameDetailViewModel
import br.com.vlabs.wiimmfiapp.ui.game.stats.GameStatsViewModel
import br.com.vlabs.wiimmfiapp.router.GameRouter
import br.com.vlabs.wiimmfiapp.router.MoreRouter
import br.com.vlabs.wiimmfiapp.ui.more.MoreViewModel
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val fabricModule = module {
    single { FirebaseRemoteConfig.getInstance() }
}

val helpers = module {
    factory { CustomTabHelper(androidContext()) }
}

val repositoryModule = module {
    single<GameRepository> { WiimmfiRepository(get()) }
}

val remoteConfig = module {
    single { AppRemoteConfig(get()) }
}

val routerModule = module {
    single { (navController: NavController) -> GameRouter(navController) }
    single { (navController: NavController) -> MoreRouter(get(), navController) }
}

val scraperModule = module {
    single { WiimmfiScraper(get()) }
}

val viewModelModule = module {
    viewModel { (args: GameDetailActivityArgs) ->
        GameDetailViewModel(args, get())
    }
    viewModel { (navController: NavController) ->
        GameStatsViewModel(get(), get { parametersOf(navController)})
    }
    viewModel { (navController: NavController) ->
        MoreViewModel(get { parametersOf(navController)})
    }
}

val appModules = listOf(
    fabricModule,
    helpers,
    repositoryModule,
    remoteConfig,
    routerModule,
    scraperModule,
    viewModelModule
)