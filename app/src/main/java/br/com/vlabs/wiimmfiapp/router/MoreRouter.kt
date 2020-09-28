package br.com.vlabs.wiimmfiapp.router

import androidx.navigation.NavController
import br.com.vlabs.wiimmfiapp.common.CustomTab

class MoreRouter(
    private val customTab: CustomTab,
    private val navController: NavController
) {

    fun openDonate() {
        customTab.open("https://wiimmfi.de/donate")
    }
}