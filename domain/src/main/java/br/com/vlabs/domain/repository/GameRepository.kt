package br.com.vlabs.domain.repository

import br.com.vlabs.domain.entity.Game
import br.com.vlabs.domain.entity.OnlineUser

interface GameRepository {

    suspend fun getStats() : List<Game>

    suspend fun getOnlineUsers() : List<OnlineUser>

}