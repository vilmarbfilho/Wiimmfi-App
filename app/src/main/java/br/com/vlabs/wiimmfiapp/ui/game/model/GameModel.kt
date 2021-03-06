package br.com.vlabs.wiimmfiapp.ui.game.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class GameModel (
    val console: ConsoleModel,
    val name: String,
    val remark: String,
    val variants: String,
    val online: String,
    val id: String
) : Parcelable