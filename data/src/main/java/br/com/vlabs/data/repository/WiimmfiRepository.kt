package br.com.vlabs.data.repository

import br.com.vlabs.data.mapper.toGame
import br.com.vlabs.data.scrap.SiteScraper
import br.com.vlabs.domain.repository.GameRepository

class WiimmfiRepository : GameRepository {

    override fun getStats() =
        SiteScraper.getGameStats().map { it.toGame() }

}