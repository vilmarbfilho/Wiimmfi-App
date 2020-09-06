package br.com.vlabs.data.scrap

import br.com.vlabs.data.GameConstants.GAME_NAME_INDEX
import br.com.vlabs.data.GameConstants.GAME_ONLINE_INDEX
import br.com.vlabs.data.GameConstants.GAME_REMARK_INDEX
import br.com.vlabs.data.GameConstants.GAME_TYPE_INDEX
import br.com.vlabs.data.GameConstants.GAME_VARIANTS_INDEX
import br.com.vlabs.data.GameConstants.HEADER_GAME_INFO_INDEX
import br.com.vlabs.data.GameConstants.HEADER_TABLE_INDEX
import br.com.vlabs.data.models.GameScraped
import br.com.vlabs.data.scrap.WiimmfiPages.URL_BASE_SITE
import br.com.vlabs.data.scrap.WiimmfiPages.PATH_GAME_STATS
import org.jsoup.Jsoup

object WiimmfiScraper {

    fun getGameStats(): List<GameScraped> {
        val html = Jsoup.connect(URL_BASE_SITE + PATH_GAME_STATS).get()
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
            val hrefDetails = it.child(GAME_NAME_INDEX).selectFirst("a").attr("href")

            GameScraped(type, name, remark, variants, online, hrefDetails)
        }

    }
}