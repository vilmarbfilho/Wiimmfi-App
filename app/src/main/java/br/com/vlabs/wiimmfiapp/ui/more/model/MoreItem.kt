package br.com.vlabs.wiimmfiapp.ui.more.model

import androidx.annotation.StringRes
import br.com.vlabs.wiimmfiapp.R

sealed class MoreItem(@StringRes open val nameRsc: Int) {

    object DONATE: MoreItem(R.string.donate_more_item)

}