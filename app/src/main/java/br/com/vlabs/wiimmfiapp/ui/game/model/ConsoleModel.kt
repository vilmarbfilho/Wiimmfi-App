package br.com.vlabs.wiimmfiapp.ui.game.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

sealed class ConsoleModel(open val name: String) : Parcelable {

    @Parcelize
    data class NDS(override val name: String) : ConsoleModel(name)

    @Parcelize
    data class WII(override val name: String) : ConsoleModel(name)

    @Parcelize
    data class WIIWARE(override val name: String) : ConsoleModel(name)

    @Parcelize
    object UNKNOWN : ConsoleModel("UNKNOWN")
}