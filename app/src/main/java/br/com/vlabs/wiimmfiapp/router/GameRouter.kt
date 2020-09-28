package br.com.vlabs.wiimmfiapp.router

import androidx.navigation.NavController
import br.com.vlabs.wiimmfiapp.ui.game.stats.GameStatsFragmentDirections
import br.com.vlabs.wiimmfiapp.ui.game.model.GameModel

class GameRouter(private val navController: NavController) {

    fun toGameDetails(game: GameModel) {
        navController.navigate(GameStatsFragmentDirections.actionGameStatsFragmentToGameDetailActivity(game))
    }
}