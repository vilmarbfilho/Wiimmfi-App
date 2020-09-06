package br.com.vlabs.data.mapper

import br.com.vlabs.data.models.GameScraped
import br.com.vlabs.domain.entity.Game

fun GameScraped.toGame() = Game(
        this.type,
        this.name,
        this.remark,
        this.variants,
        this.online,
        this.urlDetails
)
