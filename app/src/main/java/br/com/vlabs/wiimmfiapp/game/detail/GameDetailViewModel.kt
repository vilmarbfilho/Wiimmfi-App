package br.com.vlabs.wiimmfiapp.game.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.vlabs.domain.repository.GameRepository
import br.com.vlabs.wiimmfiapp.model.OnlineUserModel
import br.com.vlabs.wiimmfiapp.model.mapper.toGameModel
import br.com.vlabs.wiimmfiapp.model.mapper.toOnlineUserModel
import kotlinx.coroutines.launch
import java.io.IOException

class GameDetailViewModel(
    private val args: GameDetailActivityArgs,
    private val repository: GameRepository
) : ViewModel() {

    val showError = MutableLiveData(false)

    val loading = MutableLiveData(false)
    val onlineUsers: MutableLiveData<List<OnlineUserModel>> = MutableLiveData()

    val gameModel = MutableLiveData(args.gameModel)

    val gameConsole = MutableLiveData(args.gameModel.console)
    val gameName = MutableLiveData(args.gameModel.name)
    val gameRemark = MutableLiveData(args.gameModel.remark)
    val gameVariants = MutableLiveData(args.gameModel.variants)
    val gameOnline = MutableLiveData(args.gameModel.online)

    fun loadOnlineUsers() {
        viewModelScope.launch {
            loading.value = true
            showError.value = false

            try {
                onlineUsers.value = repository.getOnlineUsers(args.gameModel.id).map { it.toOnlineUserModel() }
            } catch (exception: IOException) {
                showError.value = true
            }

            loading.value = false
        }
    }
}