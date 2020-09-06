package br.com.vlabs.wiimmfiapp.router

import androidx.navigation.NavController
import br.com.vlabs.domain.entity.Game
import br.com.vlabs.wiimmfiapp.game.stats.GameStatsFragmentDirections

class GameRouter(private val navController: NavController) {

    fun toGameDetails(game: Game) {
        navController.navigate(GameStatsFragmentDirections.actionGameStatsFragmentToGameDetailFragment())
    }
}