package br.com.vlabs.data.models

import br.com.vlabs.data.scrap.WiimmfiPages.URL_BASE_SITE

data class GameScraped(
    val type: String,
    val name: String,
    val remark: String,
    val variants: String,
    val online: String,
    val hrefDetails: String
) {
    val urlDetails = URL_BASE_SITE + hrefDetails
}