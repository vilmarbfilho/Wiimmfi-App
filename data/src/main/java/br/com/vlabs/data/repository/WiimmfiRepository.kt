package br.com.vlabs.data.repository

import br.com.vlabs.data.common.runDefaultContext
import br.com.vlabs.data.mapper.toGame
import br.com.vlabs.data.scrap.WiimmfiScraper
import br.com.vlabs.domain.repository.GameRepository

class WiimmfiRepository : GameRepository {

    override suspend fun getStats() = runDefaultContext {
        WiimmfiScraper.getGameStats().map { it.toGame() }
    }

}