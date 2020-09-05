package br.com.vlabs.domain.repository

import br.com.vlabs.domain.entity.Game

interface GameRepository {

    fun getStats() : List<Game>

}