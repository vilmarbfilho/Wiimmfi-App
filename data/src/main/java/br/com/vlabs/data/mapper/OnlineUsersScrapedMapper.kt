package br.com.vlabs.data.mapper

import br.com.vlabs.data.models.OnlineUserScraped
import br.com.vlabs.domain.entity.OnlineUser

fun OnlineUserScraped.toOnlineUser() = OnlineUser(
    this.id4,
    this.pid,
    this.friendCode,
    this.host,
    this.gid,
    this.lsStat,
    this.olStat,
    this.status,
    this.suspend,
    this.n,
    this.name1,
    this.name2
)