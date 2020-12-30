package br.com.vlabs.data.helper

import android.os.Build

class DeviceHelper{

    fun getDeviceName(): String {
        val manufacturer = Build.MANUFACTURER
        val model = Build.MODEL

        return if (model.startsWith(manufacturer)) {
            model.capitalize()
        } else {
            manufacturer.capitalize() + " " + model.capitalize()
        }
    }

}