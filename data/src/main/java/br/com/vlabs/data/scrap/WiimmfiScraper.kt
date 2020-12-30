package br.com.vlabs.data.scrap

import br.com.vlabs.data.GameConstants.GAME_NAME_INDEX
import br.com.vlabs.data.GameConstants.GAME_ONLINE_INDEX
import br.com.vlabs.data.GameConstants.GAME_REMARK_INDEX
import br.com.vlabs.data.GameConstants.GAME_TYPE_INDEX
import br.com.vlabs.data.GameConstants.GAME_VARIANTS_INDEX
import br.com.vlabs.data.GameConstants.HEADER_GAME_INFO_INDEX
import br.com.vlabs.data.GameConstants.HEADER_TABLE_INDEX
import br.com.vlabs.data.GameConstants.HEADER_USER_ONLINE_INFO_INDEX
import br.com.vlabs.data.GameConstants.ONLINE_USER_FRIEND_CODE_INDEX
import br.com.vlabs.data.GameConstants.ONLINE_USER_GID_INDEX
import br.com.vlabs.data.GameConstants.ONLINE_USER_HOST_INDEX
import br.com.vlabs.data.GameConstants.ONLINE_USER_ID4_INDEX
import br.com.vlabs.data.GameConstants.ONLINE_USER_LS_STAT_INDEX
import br.com.vlabs.data.GameConstants.ONLINE_USER_NAME1_INDEX
import br.com.vlabs.data.GameConstants.ONLINE_USER_NAME2_INDEX
import br.com.vlabs.data.GameConstants.ONLINE_USER_N_INDEX
import br.com.vlabs.data.GameConstants.ONLINE_USER_OL_STAT_INDEX
import br.com.vlabs.data.GameConstants.ONLINE_USER_PID_INDEX
import br.com.vlabs.data.GameConstants.ONLINE_USER_STATUS_INDEX
import br.com.vlabs.data.GameConstants.ONLINE_USER_SUSPEND_INDEX
import br.com.vlabs.data.models.GameScraped
import br.com.vlabs.data.models.OnlineUserScraped
import br.com.vlabs.data.parser.JsoupParser
import br.com.vlabs.data.remoteconfig.AppRemoteConfig

class WiimmfiScraper(
    private val remoteConfig: AppRemoteConfig,
    private val parser: JsoupParser
) {

    fun getGameStats(): List<GameScraped> {
        val html = parser.get(remoteConfig.getGameStatsPage())
        val tableItems = html.select(remoteConfig.getGameStatsQuery())

        val gamesList = tableItems.filterIndexed { index, _ ->
            index > HEADER_TABLE_INDEX
                    && index > HEADER_GAME_INFO_INDEX
                    && index < tableItems.lastIndex
        }

        return gamesList.map {
            val type = it.child(GAME_TYPE_INDEX).text()
            val name = it.child(GAME_NAME_INDEX).text()
            val remark = it.child(GAME_REMARK_INDEX).text()
            val variants = it.child(GAME_VARIANTS_INDEX).text()
            val online = it.child(GAME_ONLINE_INDEX).text()

            val href = it.child(GAME_NAME_INDEX).selectFirst("a").attr("href")
            val id = href.split("/").last()

            GameScraped(id, type, name, remark, variants, online)
        }
    }

    fun getOnlineUsers(id: String): List<OnlineUserScraped> {
        val html = parser.get("${remoteConfig.getOnLineUsersPage()}/$id")
        val tableItems = html.select(remoteConfig.getOnLineUsersQuery())

        val onlineUsersList = tableItems.filterIndexed { index, _ ->
            index > HEADER_TABLE_INDEX
                    && index > HEADER_USER_ONLINE_INFO_INDEX
        }

        return onlineUsersList.map {
            val id4 = it.child(ONLINE_USER_ID4_INDEX).text()
            val pid = it.child(ONLINE_USER_PID_INDEX).text()
            val friendCode = it.child(ONLINE_USER_FRIEND_CODE_INDEX).text()
            val host = it.child(ONLINE_USER_HOST_INDEX).text()
            val gid = it.child(ONLINE_USER_GID_INDEX).text()
            val lsStat = it.child(ONLINE_USER_LS_STAT_INDEX).text()
            val olStat = it.child(ONLINE_USER_OL_STAT_INDEX).text()
            val status = it.child(ONLINE_USER_STATUS_INDEX).text()
            val suspend = it.child(ONLINE_USER_SUSPEND_INDEX).text()
            val n = it.child(ONLINE_USER_N_INDEX).text()
            val name1 = it.child(ONLINE_USER_NAME1_INDEX).text()
            val name2 = it.child(ONLINE_USER_NAME2_INDEX).text()

            OnlineUserScraped(
                id4,
                pid,
                friendCode,
                host,
                gid,
                lsStat,
                olStat,
                status,
                suspend,
                n,
                name1,
                name2
            )
        }
    }
}