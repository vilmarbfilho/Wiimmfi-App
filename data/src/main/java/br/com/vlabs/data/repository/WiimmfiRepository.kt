package br.com.vlabs.data.repository

import br.com.vlabs.data.common.runDefaultContext
import br.com.vlabs.data.mapper.toGame
import br.com.vlabs.data.mapper.toOnlineUser
import br.com.vlabs.data.scrap.WiimmfiScraper
import br.com.vlabs.domain.repository.GameRepository

class WiimmfiRepository(private val scraper: WiimmfiScraper) : GameRepository {

    override suspend fun getStats() = runDefaultContext {
        scraper.getGameStats().map { it.toGame() }
    }

    override suspend fun getOnlineUsers(id: String) = runDefaultContext {
        scraper.getOnlineUsers(id).map { it.toOnlineUser() }
    }

}