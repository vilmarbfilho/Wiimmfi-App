package br.com.vlabs.wiimmfiapp.game.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameDetailViewModel(
    private val args: GameDetailFragmentArgs
) : ViewModel() {

    val gameConsole = MutableLiveData(args.gameModel.console)
    val gameName = MutableLiveData(args.gameModel.name)
    val gameRemark = MutableLiveData(args.gameModel.remark)
    val gameVariants = MutableLiveData(args.gameModel.variants)
    val gameOnline = MutableLiveData(args.gameModel.online)

}