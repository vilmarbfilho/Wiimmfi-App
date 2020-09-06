package br.com.vlabs.wiimmfiapp.model

import br.com.vlabs.wiimmfiapp.R

fun ConsoleModel.toImageResource() = when (this) {
    is ConsoleModel.NDS -> R.drawable.nds
    is ConsoleModel.WII -> R.drawable.wii
    is ConsoleModel.WIIWARE -> R.drawable.wiiware
    else -> 0
}