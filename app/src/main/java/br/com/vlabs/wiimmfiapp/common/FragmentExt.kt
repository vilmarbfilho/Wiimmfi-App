package br.com.vlabs.wiimmfiapp.common

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

fun Fragment.setToolbar(toolbar: Toolbar?, title: String? = null) {
    if(activity is AppCompatActivity){
        (activity as AppCompatActivity).setSupportActionBar(toolbar)

        title?.let {
            (activity as AppCompatActivity).supportActionBar?.title = it
        }
    }
}

fun Fragment.getActionBar() = if (activity is AppCompatActivity) {
    (activity as AppCompatActivity).supportActionBar
} else {
    null
}