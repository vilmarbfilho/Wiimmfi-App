package br.com.vlabs.wiimmfiapp.router

import androidx.navigation.NavController
import br.com.vlabs.wiimmfiapp.game.stats.GameStatsFragmentDirections
import br.com.vlabs.wiimmfiapp.model.GameModel

class GameRouter(private val navController: NavController) {

    fun toGameDetails(game: GameModel) {
        navController.navigate(GameStatsFragmentDirections.actionGameStatsFragmentToGameDetailFragment(game))
    }
}