package br.com.vlabs.wiimmfiapp.common

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.res.ResourcesCompat
import br.com.vlabs.wiimmfiapp.R

class CustomTab(private val context: Context) {

    fun open(url: String) {
        val builder = CustomTabsIntent.Builder()
        builder.setToolbarColor(ResourcesCompat.getColor(context.resources, R.color.colorPrimary, null))
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(context, Uri.parse(url))
    }

}