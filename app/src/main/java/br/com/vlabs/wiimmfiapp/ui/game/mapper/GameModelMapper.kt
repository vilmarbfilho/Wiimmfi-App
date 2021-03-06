package br.com.vlabs.wiimmfiapp.ui.game.mapper

import br.com.vlabs.domain.entity.Game
import br.com.vlabs.wiimmfiapp.ui.game.model.ConsoleModel
import br.com.vlabs.wiimmfiapp.ui.game.model.GameModel

fun Game.toGameModel() = GameModel(
    toConsoleModel(this.type),
    this.name,
    this.remark,
    this.variants,
    this.online,
    this.id
)

fun toConsoleModel(type: String) = when (type.toLowerCase()) {
    "wii" -> ConsoleModel.WII(type)
    "nds" -> ConsoleModel.NDS(type)
    "wiiware" -> ConsoleModel.WIIWARE(type)
    else -> ConsoleModel.UNKNOWN
}