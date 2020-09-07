package br.com.vlabs.wiimmfiapp.game.stats

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.vlabs.domain.repository.GameRepository
import br.com.vlabs.wiimmfiapp.model.GameModel
import br.com.vlabs.wiimmfiapp.model.mapper.toGameModel
import br.com.vlabs.wiimmfiapp.router.GameRouter
import kotlinx.coroutines.launch
import java.io.IOException

class GameStatsViewModel(
    private val repository: GameRepository,
    private val router: GameRouter
) : ViewModel() {

    val loading = MutableLiveData(false)
    val gameStats: MutableLiveData<List<GameModel>> = MutableLiveData()

    val showError = MutableLiveData(false)

    fun getGamesStats() {
        viewModelScope.launch {
            loading.value = true
            showError.value = false

            try {
                gameStats.value = repository.getStats().map { it.toGameModel() }
            } catch (exception: IOException) {
                showError.value = true
            }

            loading.value = false
        }
    }

    fun onGameClicked(game: GameModel) {
        router.toGameDetails(game)
    }
}