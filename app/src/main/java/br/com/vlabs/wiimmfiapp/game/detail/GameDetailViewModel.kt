package br.com.vlabs.wiimmfiapp.game.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.vlabs.domain.repository.GameRepository
import br.com.vlabs.wiimmfiapp.model.OnlineUserModel
import br.com.vlabs.wiimmfiapp.model.mapper.toOnlineUserModel
import kotlinx.coroutines.launch

class GameDetailViewModel(
    private val args: GameDetailFragmentArgs,
    private val repository: GameRepository
) : ViewModel() {

    val loading = MutableLiveData(false)
    val onlineUsers: MutableLiveData<List<OnlineUserModel>> = MutableLiveData()

    val gameConsole = MutableLiveData(args.gameModel.console)
    val gameName = MutableLiveData(args.gameModel.name)
    val gameRemark = MutableLiveData(args.gameModel.remark)
    val gameVariants = MutableLiveData(args.gameModel.variants)
    val gameOnline = MutableLiveData(args.gameModel.online)

    fun loadOnlineUsers() {
        viewModelScope.launch {
            loading.value = true

            onlineUsers.value = repository.getOnlineUsers(args.gameModel.id).map { it.toOnlineUserModel() }

            loading.value = false
        }
    }
}