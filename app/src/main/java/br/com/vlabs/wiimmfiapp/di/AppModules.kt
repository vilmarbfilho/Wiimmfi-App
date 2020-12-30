package br.com.vlabs.wiimmfiapp.di

import android.os.Build
import androidx.navigation.NavController
import br.com.vlabs.data.helper.DeviceHelper
import br.com.vlabs.data.parser.ConfigParser
import br.com.vlabs.data.parser.JsoupParser
import br.com.vlabs.data.remoteconfig.AppRemoteConfig
import br.com.vlabs.data.repository.WiimmfiRepository
import br.com.vlabs.data.scrap.WiimmfiScraper
import br.com.vlabs.domain.repository.GameRepository
import br.com.vlabs.wiimmfiapp.BuildConfig
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

val configParser = module {
   single {
       ConfigParser(
           versionApp = BuildConfig.VERSION_NAME,
           versionOS = Build.VERSION.SDK_INT,
           deviceName = get<DeviceHelper>().getDeviceName()
       )
   }
}

val fabricModule = module {
    single { FirebaseRemoteConfig.getInstance() }
}

val helpers = module {
    factory { CustomTabHelper(androidContext()) }
    single { JsoupParser(get()) }
    single { DeviceHelper() }
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
    single { WiimmfiScraper(get(), get()) }
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
    configParser,
    fabricModule,
    helpers,
    repositoryModule,
    remoteConfig,
    routerModule,
    scraperModule,
    viewModelModule
)