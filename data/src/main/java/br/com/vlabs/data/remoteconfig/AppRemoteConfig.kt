package br.com.vlabs.data.remoteconfig

import br.com.vlabs.data.R
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings

class AppRemoteConfig(private val remoteConfig: FirebaseRemoteConfig) {

    init {
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }

        remoteConfig.setConfigSettingsAsync(configSettings)

        remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)

        remoteConfig.fetchAndActivate()

        remoteConfig.fetch()
    }

    fun getGameStatsPage() = remoteConfig.getString("game_stats_page")

    fun getGameStatsQuery() = remoteConfig.getString("game_stats_query")

    fun getOnLineUsersPage() = remoteConfig.getString("online_users_page")

    fun getOnLineUsersQuery() = remoteConfig.getString("online_users_query")

}