package br.com.vlabs.data.mapper

import br.com.vlabs.data.models.GameScraped
import br.com.vlabs.domain.entity.Console
import br.com.vlabs.domain.entity.Game

fun GameScraped.toGame() = Game(
        toConsole(this.type),
        this.name,
        this.remark,
        this.variants,
        this.online
)

fun toConsole(type: String) = when (type.toLowerCase()) {
        "wii" -> Console.WII(type)
        "nds" -> Console.NDS(type)
        "wiiware" -> Console.WIIWARE(type)
        else -> Console.UNKNOWN
}