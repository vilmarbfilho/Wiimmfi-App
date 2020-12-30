package br.com.vlabs.data.parser

import org.jsoup.Jsoup

class JsoupParser(
    config: ConfigParser
) {

    private val USER_AGENT =
        "Wiimmfi-App/${config.versionApp} (Android ${config.versionOS}; ${config.deviceName}) VilmarBFilho (https://github.com/vilmarbfilho/Wiimmfi-App)"

    fun get(url: String) = Jsoup.connect(url).userAgent(USER_AGENT).get()
}