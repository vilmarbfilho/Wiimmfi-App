package br.com.vlabs.data.scrap

import br.com.vlabs.data.GameConstants.GAME_NAME_INDEX
import br.com.vlabs.data.GameConstants.GAME_ONLINE_INDEX
import br.com.vlabs.data.GameConstants.GAME_REMARK_INDEX
import br.com.vlabs.data.GameConstants.GAME_TYPE_INDEX
import br.com.vlabs.data.GameConstants.GAME_VARIANTS_INDEX
import br.com.vlabs.data.GameConstants.HEADER_GAME_INFO_INDEX
import br.com.vlabs.data.GameConstants.HEADER_TABLE_INDEX
import br.com.vlabs.data.models.GameScrap
import org.jsoup.Jsoup

object SiteScraper {

    fun getGameStats(): List<GameScrap> {
        val html = Jsoup.connect(WiimmfiPages.GAME_STATS).get()
        val tableItems = html.select("table#game tbody tr")

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

            GameScrap(type, name, remark, variants, online)
        }

    }
}