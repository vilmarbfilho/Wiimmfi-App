package br.com.vlabs.wiimmfiapp.ui.game.mapper

import br.com.vlabs.domain.entity.OnlineUser
import br.com.vlabs.wiimmfiapp.ui.game.model.OnlineUserModel

fun OnlineUser.toOnlineUserModel() = OnlineUserModel(
    this.friendCode,
    this.status,
    this.name1
)