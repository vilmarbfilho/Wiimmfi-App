package br.com.vlabs.wiimmfiapp.game.stats

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.vlabs.domain.entity.Game
import br.com.vlabs.domain.repository.GameRepository
import kotlinx.coroutines.launch

class GameStatsViewModel(
    private val repository: GameRepository
) : ViewModel() {

    val loading = MutableLiveData(false)
    val gameStats: MutableLiveData<List<Game>> = MutableLiveData()

    fun getGamesStats() {
        viewModelScope.launch {
            loading.value = true

            gameStats.value = repository.getStats()

            loading.value = false
        }
    }
}