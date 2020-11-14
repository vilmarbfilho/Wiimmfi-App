package br.com.vlabs.wiimmfiapp.common.viewbinding

import android.app.Activity
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * References
 *
 * https://medium.com/easyread/how-to-simplify-your-android-view-binding-delegation-d07812b2a616
 *
 * https://github.com/yogacp/android-viewbinding
 *
 * https://jamie.sanson.dev/blog/handing-the-reins-to-kotlin-delegates-part-1-what-and-why/
 */

inline fun <reified T : ViewBinding> Activity.viewBinding() = ActivityViewBindingDelegate(T::class.java)

class ActivityViewBindingDelegate<T : ViewBinding>(private val bindingClass: Class<T>) :
    ReadOnlyProperty<Activity, T> {

    private var binding: T? = null

    override fun getValue(thisRef: Activity, property: KProperty<*>): T {
        binding?.let { return it }

        val inflateMethod = bindingClass.getMethod("inflate", LayoutInflater::class.java)

        val invokeLayout = inflateMethod.invoke(null, thisRef.layoutInflater) as T

        thisRef.setContentView(invokeLayout.root)

        return invokeLayout.also { this.binding = it }
    }
}