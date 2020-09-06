package br.com.vlabs.domain.repository

import br.com.vlabs.domain.entity.Game

interface GameRepository {

    suspend fun getStats() : List<Game>

}